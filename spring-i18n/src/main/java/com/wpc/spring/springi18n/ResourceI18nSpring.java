package com.wpc.spring.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * @author wpc
 * @date 2023/10/18 8:53
 */
public class ResourceI18nSpring {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:bean.xml");
        Object[] objs = new Object[]{"aaaa",new Date().toString()};
        String value1 = context.getMessage("www.wpc.com", objs, Locale.CHINA);
        System.out.println("value1 = " + value1);

    }
}
