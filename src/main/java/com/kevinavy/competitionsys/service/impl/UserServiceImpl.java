package com.kevinavy.competitionsys.service.impl;

import com.kevinavy.competitionsys.mapper.UserMapper;
import com.kevinavy.competitionsys.model.response.Response;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {

    private static final String SECRET = "a2V2aW5hdnk=";

    @Resource
    UserMapper userMapper;

    public Response register(String username, String password) {
//        if (ObjectUtils.isEmpty(userMapper.findUserByUsername(username))) {
//            return Response.error("该用户已被注册");
//        }
        userMapper.register(username, DigestUtils.md5Hex(password + SECRET), System.currentTimeMillis());
        return Response.success("注册成功！");
    }
}
