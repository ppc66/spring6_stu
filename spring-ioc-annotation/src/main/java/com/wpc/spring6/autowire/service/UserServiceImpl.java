package com.wpc.spring6.autowire.service;

import com.wpc.spring6.autowire.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wpc
 * @date 2023/10/12 8:44
 */
@Service("service")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void add() {
        userDao.add();
        System.out.println("service.....");
    }
}
