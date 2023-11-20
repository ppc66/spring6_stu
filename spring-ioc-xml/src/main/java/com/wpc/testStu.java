package com.wpc;

import com.wpc.bean.di.dimap.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/10 15:36
 */
public class testStu {
    @Test
    public void testStu(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-di-ref.xml");
        Student student = context.getBean("student1", Student.class);
        student.run();
    }
}
