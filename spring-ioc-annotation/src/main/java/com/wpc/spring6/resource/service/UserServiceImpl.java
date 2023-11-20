package com.wpc.spring6.resource.service;

import com.wpc.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wpc
 * @date 2023/10/12 8:44
 */
@Service(value = "myUserService")
public class UserServiceImpl implements UserService {
    //不指定名称，根据属性名称进行注入
    @Resource
    private UserDao userDao;

    @Override
    public void add() {
        userDao.add();
        System.out.println("service.....");
    }
}
