package com.wpc.dao.impl;

import com.wpc.anno.Bean;
import com.wpc.dao.UserDao;

/**
 * @author wpc
 * @date 2023/10/12 16:15
 */
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao....");
    }
}
