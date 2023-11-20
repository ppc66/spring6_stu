package com.wpc.spring6.autowire.controller;

import com.wpc.spring6.autowire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author wpc
 * @date 2023/10/12 8:43
 */
@Controller("controller")
public class UserController {
    //第一种方式  byType找到对应的类型实现注入
//    @Autowired
//    @Qualifier("userServiceImpl")
    private UserService userService;
    //第二种方式注入
//    @Autowired
//    public void setUserService(UserService userService){
//        this.userService = userService;
//    }
    //第三种方式
//    //加在方法上也行
//    public UserController(@Autowired  UserService userService) {
//        this.userService = userService;
//    }

    //只有一个参数的构造函数，可以不用添加注解  也只能有一个构造函数
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //



//    public UserController() {
//    }
    public void add(){
        userService.add();
        System.out.println("controller...");
    }
}
