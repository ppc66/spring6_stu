package com.wpc.spring6.autowire.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author wpc
 * @date 2023/10/12 8:44
 */
@Repository("dao")
public class UserDaoImpl implements UserDao {
    // 第一种方式属性注入
    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("dao...");
    }
}
