package com.wpc.auto.service;

import com.wpc.auto.dao.UserDao;

/**
 * @author wpc
 * @date 2023/10/11 9:44
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        System.out.println("userService方法执行了...");
        userDao.addUserDao();
    }
}
