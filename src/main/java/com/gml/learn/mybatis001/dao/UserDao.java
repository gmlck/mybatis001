package com.gml.learn.mybatis001.dao;

import com.gml.learn.mybatis001.po.User;

import java.util.List;

/**
 * 对User的操作接口
 * @author minglug
 * @date 2016/12/16
 */
public interface UserDao {
    /**
     * 根据id查询User
     * @param id 主键
     * @return User
     */
    User findUserById(int id);

    /**
     * 根据name查询User
     * @param name 用户名
     * @return 满足条件0个或多个user
     */
    List<User> findUserByName(String name);
    /**
     * 添加User
     * @param user 添加内容
     */
    void insertUser(User user);

    /**
     * 根据id删除User
     * @param id 主键
     */
    void deleteUser(int id);
}
