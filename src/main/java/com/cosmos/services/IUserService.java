package com.cosmos.services;

import com.cosmos.requestbeans.UserRequest;
import com.cosmos.responsebeans.UserResponse;

import java.util.List;

public interface IUserService {

    UserResponse saveUser(UserRequest user);
    UserResponse findUserById(String id);
    List<UserResponse> findAllUsers();
    UserResponse updateUser(UserRequest newUser);
    void deleteuser(String id);
}
