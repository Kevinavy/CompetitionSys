package com.kevinavy.competitionsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kevinavy.competitionsys.constant.enums.ResponseCode;
import com.kevinavy.competitionsys.mapper.RoleMapper;
import com.kevinavy.competitionsys.mapper.UserMapper;
import com.kevinavy.competitionsys.model.common.Response;
import com.kevinavy.competitionsys.model.po.Role;
import com.kevinavy.competitionsys.model.vo.RoleVo;
import com.kevinavy.competitionsys.model.vo.UserVo;
import com.kevinavy.competitionsys.security.JsonWebTokenCenter;
import com.kevinavy.competitionsys.security.model.SecurityUserDetails;
import com.kevinavy.competitionsys.model.po.User;
import com.kevinavy.competitionsys.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    UserMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Override
    public Response register(UserVo user) {
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        boolean isDelete = false;
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(user.getPassword())) {
            //校验是否为学号
            if (!validStudentId(username)) {
                return Response.error(ResponseCode.UNAUTHORIZED, "请使用正确的学号注册");
            }
            //校验用户名是否已被注册
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getUsername, username);
            User userTemp = userMapper.selectOne(queryWrapper);
            if (!ObjectUtils.isEmpty(userTemp) && !(isDelete = userTemp.getIsDelete() == 1)) {
                return Response.error(ResponseCode.UNAUTHORIZED, "该学号已被注册！");
            }
        }
        else {
            return Response.error(ResponseCode.UNAUTHORIZED, "用户名或密码不能为空");
        }

        if (StringUtils.isEmpty(user.getName())) {
            return Response.error(ResponseCode.UNAUTHORIZED, "姓名不能为空");
        }
        else if (StringUtils.isEmpty(user.getClazz())) {
            return Response.error(ResponseCode.UNAUTHORIZED, "班级不能为空");
        }
        else if (StringUtils.isEmpty(user.getInstitute())) {
            return Response.error(ResponseCode.UNAUTHORIZED, "学院不能为空");
        }

        //执行注册
        if (isDelete) {
            userMapper.updateIsDelete(username, 0);
            userMapper.updatePassword(username, password);
            userMapper.updateName(username, user.getName());
            userMapper.updateClazz(username, user.getClazz());
            userMapper.updateInstitute(username, user.getInstitute());
        }
        else {
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            User userData = new User(user);
            userData.setPassword(password);
            userData.setCreateTime(currentTimestamp);
            userData.setUpdateTime(currentTimestamp);
            userData.setIsDelete(0);
            userData.setIsLocked(0);
            userMapper.insert(userData);
        }

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User userValid = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(userValid)) {
            return Response.error("注册失败！");
        }
        else {
            userMapper.setCommonRole(userValid.getId());
        }

        return Response.success("注册成功！", null);
    }

    @Override
    public Response login(UserVo user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (ObjectUtils.isEmpty(authenticate)) {
            throw new RuntimeException("登录失败！");
        }

        SecurityUserDetails securityUserDetails = (SecurityUserDetails) authenticate.getPrincipal();
        Map<String, Object> responseData = new HashMap<>(2);
        responseData.put("token", JsonWebTokenCenter.getToken(user.getUsername()));



        // todo 将用户信息存入redis


        userMapper.updateLoginTime(user.getUsername(), new Timestamp(System.currentTimeMillis()));

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User userTemp = userMapper.selectOne(queryWrapper);
        responseData.put("userInfo", new UserVo(userTemp));
        Role role = roleMapper.getRoleByUserId(userTemp.getId());
        responseData.put("userRole", new RoleVo(role));
        return Response.success("登录成功！", responseData);
    }

    @Override
    public Response logout() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        SecurityUserDetails securityUserDetails = (SecurityUserDetails) authentication.getPrincipal();
        String username = securityUserDetails.getUsername();
        // todo 删除redis中的用户信息

        return Response.success("注销成功！");
    }

    @Override
    public Response deleteUser(UserVo user) {
        userMapper.updateIsDelete(user.getUsername(), 1);
        return Response.success("删除成功！");
    }

    @Override
    public Response updateUser(UserVo user) {
        return null;
    }

    private Boolean validStudentId(String id) {
        if (id.length() == 12 && StringUtils.isNumeric(id) && !id.endsWith("00")) {
            Integer year = Calendar.getInstance().get(Calendar.YEAR);
            Integer enrollmentYear = Integer.valueOf(id.substring(0, 4));
            return year - enrollmentYear < 7 || year - enrollmentYear > 0;
        }
        return false;
    }
}
