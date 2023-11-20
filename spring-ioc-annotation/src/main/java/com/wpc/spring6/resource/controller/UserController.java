package com.wpc.spring6.resource.controller;

import com.wpc.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * @author wpc
 * @date 2023/10/12 8:43
 */
@Controller
public class UserController {
    //根据名称进行注入
    @Resource(name = "myUserService")
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add(){
        userService.add();
        System.out.println("controller...");
    }
}
