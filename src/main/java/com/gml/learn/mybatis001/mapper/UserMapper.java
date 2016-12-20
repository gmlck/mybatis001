package com.gml.learn.mybatis001.mapper;

import com.gml.learn.mybatis001.po.User;

import java.util.List;

/**
 * @author minglug
 * @date 2016/12/20
 */
public interface UserMapper {
    User findUserById(int id);

    List<User> findUserByNameAndSex(User user);

    List<User> findUserByName(String name);

    void insertUser(User user);

    void deleteUser(int id);
}
