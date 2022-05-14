package com.kevinavy.competitionsys.controller;

import com.kevinavy.competitionsys.model.common.Response;
import com.kevinavy.competitionsys.model.vo.UserVo;
import com.kevinavy.competitionsys.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody UserVo user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Response login(@RequestBody UserVo user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public Response login() {
        return userService.logout();
    }

    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    public Response deleteUser(@RequestBody UserVo user) {
        return userService.deleteUser(user);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sys:user:update')")
    public Response updateUser(@RequestBody UserVo user) {
        return userService.updateUser(user);
    }

}
