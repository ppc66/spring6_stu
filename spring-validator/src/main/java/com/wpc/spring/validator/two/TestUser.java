package com.wpc.spring.validator.two;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wpc
 * @date 2023/10/18 9:53
 */
public class TestUser {
    @Test
    public void testValidator1(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidation1 val1 = context.getBean(MyValidation1.class);
        User user = new User();
        user.setAge(2);
        user.setName("123");
        boolean b = val1.validatorByUser(user);
        System.out.println("b = " + b);
    }
    @Test
    public void testValidator2(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidation2 val2 = context.getBean(MyValidation2.class);
        User user = new User();
        user.setAge(1300);
        user.setName("123");
        boolean b = val2.validatorByUser2(user);
        System.out.println("b 1= " + b); // false 表示没有错误
    }
}
