package com.wpc;

import com.wpc.bean.MyAnnotationApplicationContext;
import com.wpc.bean.MyApplicationContext;
import com.wpc.service.UserService;
import com.wpc.service.impl.UserServiceImpl;

/**
 * @author wpc
 * @date 2023/10/12 21:21
 */
public class testUser {
    public static void main(String[] args) throws Exception {
        MyApplicationContext context =
                new MyAnnotationApplicationContext("com.wpc");
        UserService userService = (UserService)context.getBean(UserService.class);
        System.out.println("userService = " + userService);
        userService.add();
    }
}
