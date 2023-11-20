package com.wpc;

import com.wpc.bean.di.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/10 13:48
 */
public class TestBook {
    /**
     * 基于set方法注入
     */
    @Test
    public void testSetter(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = (Book)context.getBean("book");
        System.out.println("book = " + book);
    }

    /**
     * 基于构造器注入
     */
    @Test
    public void testCon(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = (Book)context.getBean("book1");
        System.out.println("book = " + book);
    }
}
