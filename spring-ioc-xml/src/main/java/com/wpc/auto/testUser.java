package com.wpc.auto;

import com.wpc.auto.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/11 10:32
 */
public class testUser {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController bean = context.getBean(UserController.class);
        bean.addUser();
    }
}
