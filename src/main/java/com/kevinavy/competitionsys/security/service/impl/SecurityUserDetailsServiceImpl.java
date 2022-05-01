package com.kevinavy.competitionsys.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kevinavy.competitionsys.security.mapper.SecurityPermissionMapper;
import com.kevinavy.competitionsys.security.mapper.SecurityUserMapper;
import com.kevinavy.competitionsys.security.model.SecurityUserDetails;
import com.kevinavy.competitionsys.security.model.User;
import com.kevinavy.competitionsys.security.service.intf.SecurityUserDetailsService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private SecurityUserMapper securityUserMapper;

    @Resource
    private SecurityPermissionMapper securityPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = securityUserMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)) {
            throw new RuntimeException("用户名或密码错误11");
        }


        return new SecurityUserDetails(user);
    }
}
