package com.wpc;

import com.wpc.bean.di.Dept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/10 15:22
 */
public class testDeptList {
    @Test
    public void testDept(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-di-list.xml");
        Dept dept = (Dept)context.getBean("dept");
        dept.info();
    }
}
