package com.wpc.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/11 9:03
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-scope.xml");
        test test1 = context.getBean("test1", test.class);
        test test2 = context.getBean("test2", test.class);
        test test3 = context.getBean("test2", test.class);
        System.out.println("test1 = " + test1);
        System.out.println("test2 = " + test2);
        System.out.println("test3 = " + test3);
    }
}
