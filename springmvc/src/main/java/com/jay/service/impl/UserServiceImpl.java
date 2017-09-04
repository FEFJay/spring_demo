package com.jay.service.impl;

import com.jay.dao.UserDao;
import com.jay.entities.User;
import com.jay.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImpl")
@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        System.out.println("UserServiceImpl.getAllUser");
        return userDao.getAllUsers();
    }
}
