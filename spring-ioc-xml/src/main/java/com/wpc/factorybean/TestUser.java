package com.wpc.factorybean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/11 9:39
 */
public class TestUser {
    @Test
    public void testUser(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-factorybean.xml");
        User bean = context.getBean(User.class);
        System.out.println("bean = " + bean);
    }
}
