package com.poxiao.springboot01.service.impl;

import com.poxiao.springboot01.dao.entity.User;
import com.poxiao.springboot01.dao.mapper.UserMapper;
import com.poxiao.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserSerivceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser(){
        System.out.println("开始查找所有用户");
        return userMapper.listUser();
    }

    //获取用户
    @Override
    public User getById(Integer id) {
        System.out.println("根据ID查找用户");
        return userMapper.getById(id);
    }

    @Override
    public void insertUser(User user) {
        System.out.println("开始添加用户");
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("开始更新用户");
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        System.out.println("开始删除用户");
        userMapper.deleteUserById(id);
    }

}
