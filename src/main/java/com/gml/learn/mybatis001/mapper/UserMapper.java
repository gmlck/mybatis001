package com.gml.learn.mybatis001.mapper;

import com.gml.learn.mybatis001.po.User;
import com.gml.learn.mybatis001.po.UserCustom;
import com.gml.learn.mybatis001.po.UserQueryVo;

import java.util.List;
import java.util.Map;

/**
 * @author minglug
 * @date 2016/12/20
 */
public interface UserMapper {
    void deleteUser(int id);

    User findUserById(int id);

    User findUserByIdResultMap(int id);

    List<User> findUserByName(String name);

    int findUserCount();

    List<UserCustom> findUserList(UserQueryVo userQueryVo);

    List<UserCustom> findUserList2(Map<String, String> map);

    void insertUser(User user);
}
