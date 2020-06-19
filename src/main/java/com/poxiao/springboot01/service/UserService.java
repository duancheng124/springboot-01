package com.poxiao.springboot01.service;

import com.poxiao.springboot01.dao.entity.User;

import java.util.List;

public interface UserService {
    List<User> listUser();

    User getById(Integer id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);

}
