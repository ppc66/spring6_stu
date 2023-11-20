package com.wpc.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author wpc
 * @date 2023/10/11 9:37
 */
public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        System.out.println("执行getObject方法");
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
