package com.wpc.test;


import com.wpc.entity.User;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * @author wpc
 * @date 2023/10/9 14:48
 */

/**
 * 1、加载bean.xml
 */
public class testUser {
    private Logger logger = LoggerFactory.getLogger(testUser.class);

    @Test
    public void testUserObject(){
        //创建日志对象

        //
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User)context.getBean("user");
        user.add();
        //手动写日志
        logger.info("info日志");
        System.out.println("user = " + user);
    }

    @Test
    public void testObject1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("com.wpc.entity.User");
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println("user = " + user);
    }


}
