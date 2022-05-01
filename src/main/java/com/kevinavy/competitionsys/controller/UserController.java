package com.kevinavy.competitionsys.controller;

import com.kevinavy.competitionsys.model.response.Response;
import com.kevinavy.competitionsys.service.impl.UserServiceImpl;
import com.kevinavy.competitionsys.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServiceImpl userService;

    @PostMapping("/register")
    public Response register(String username, String password) {
        return userService.register(username, password);
    }

    @RequestMapping("/hello")
    public String test() {
        return "Response.success()";
    }

//    @PostMapping("/login")
//    public Response login() {
//
//    }
//
//    @PostMapping("/logout")
//    public Response login() {
//
//    }

}
