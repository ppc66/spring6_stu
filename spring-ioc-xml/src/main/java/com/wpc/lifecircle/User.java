package com.wpc.lifecircle;

import org.apache.logging.log4j.core.config.AppendersPlugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wpc
 * @date 2023/10/11 9:14
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    //初始化的方法
    public void initMethod(){
        System.out.println("4 bean对象的初始化，会调用指定的初始化方法");
    }
    //销毁的方法
    public void destroyMethod(){
        System.out.println("5 bean对象的销毁，会调用指定的销毁方法");
    }

    public void setName(String name) {
        System.out.println("2 在set方法中注入属性");
        this.name = name;
    }

    public User(){
        System.out.println("1 调用无参数构造，创建bean对象");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean-life.xml");
        User bean = context.getBean(User.class);
        System.out.println("bean = " + bean);
        System.out.println("bean对象创建成功可以使用了");
        context.close();
    }
}
