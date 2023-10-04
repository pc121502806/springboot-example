package com.wade.springbootexample.service.impl;

import com.wade.springbootexample.dao.UserDao;
import com.wade.springbootexample.dto.UserRegisterRequest;
import com.wade.springbootexample.model.User;
import com.wade.springbootexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
