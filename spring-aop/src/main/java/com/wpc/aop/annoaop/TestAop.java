package com.wpc.aop.annoaop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/13 15:53
 */
public class TestAop {
    @Test
    public void testAddBefore(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(2,3);
    }
}
