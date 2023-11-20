package com.wpc.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/11 8:46
 */
public class testJdbc {
    @Test
    public void demo1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/atguigudb?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("dcqdy");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }
    @Test
    public void demo2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUrl());
    }
}
