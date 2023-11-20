package com.wpc;

import com.wpc.bean.di.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/10 14:29
 */
public class testEmp {
    @Test
    public void testEmp(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-di-array.xml");
        Employee emp = (Employee)context.getBean("emp");
        System.out.println("emp = " + emp);
    }
}
