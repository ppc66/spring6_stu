package com.wpc.spring6.resource.dao;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author wpc
 * @date 2023/10/12 8:44
 */
@Repository("myUserDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("dao...");
    }
}
