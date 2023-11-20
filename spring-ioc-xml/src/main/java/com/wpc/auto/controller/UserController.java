package com.wpc.auto.controller;

import com.wpc.auto.service.UserService;
import com.wpc.auto.service.UserServiceImpl;

/**
 * @author wpc
 * @date 2023/10/11 9:43
 */
public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法执行了");
        userService.addUser();

    }
}
