package com.wade.springbootexample.dao;

import com.wade.springbootexample.dto.UserRegisterRequest;
import com.wade.springbootexample.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
