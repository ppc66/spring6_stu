package com.wpc;


import com.wpc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/10 9:14
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean
        User user1 = (User) context.getBean("user");
        System.out.println("根据id获取bean " + user1);

        User user2 = context.getBean(User.class);
        System.out.println("根据类型获取bean" + user2);

        User user3 = context.getBean("user", User.class);
        System.out.println("根据类型和id获取bean" + user3);
    }
}
