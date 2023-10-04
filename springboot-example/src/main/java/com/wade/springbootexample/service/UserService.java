package com.wade.springbootexample.service;

import com.wade.springbootexample.dto.UserRegisterRequest;
import com.wade.springbootexample.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
