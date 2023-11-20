package com.wpc.spring.validator.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wpc
 * @date 2023/10/18 10:15
 */
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = context.getBean(MyService.class);
        User user = new User();
        user.setName("lucy");
        user.setPhone("15371667261");
        user.setAge(10);
        user.setMessage("asd saads");
        String s = service.testMethod(user);
        System.out.println("s = " + s);

    }
}
