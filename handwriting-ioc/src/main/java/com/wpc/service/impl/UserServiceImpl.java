package com.wpc.service.impl;

import com.wpc.anno.Bean;
import com.wpc.anno.Di;
import com.wpc.dao.UserDao;
import com.wpc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wpc
 * @date 2023/10/12 16:13
 */
@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service....");
        userDao.add();
    }
}
