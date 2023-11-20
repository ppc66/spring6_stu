package com.wpc.spring6.resource;

import com.wpc.spring6.config.SpringConfig;
import com.wpc.spring6.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wpc
 * @date 2023/10/12 10:43
 */
public class testAnno {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);
        userController.add();
    }
}
