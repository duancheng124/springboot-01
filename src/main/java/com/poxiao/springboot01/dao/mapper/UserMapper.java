package com.poxiao.springboot01.dao.mapper;

import com.poxiao.springboot01.dao.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> listUser();

    //根据id获取一条信息
    User getById(Integer id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);

}
