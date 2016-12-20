package com.gml.learn.mybatis001.dao;

import com.gml.learn.mybatis001.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author minglug
 * @date 2016/12/16
 */
public class UserDaoImplTest {
    UserDao userDao;
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config/SqlMapConfig.xml"));
        UserDaoImpl userDao1 = new UserDaoImpl();
        userDao1.sqlSessionFactory = sqlSessionFactory;
        userDao = userDao1;
    }
    @Test
    public void findUserById() throws Exception {
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void findUserByName() throws Exception {
        List<User> users = userDao.findUserByName("%小明%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setSex("0");
        user.setUsername("test1");
        user.setAddress("addr");
        user.setBirthday(new Date());
        userDao.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void deleteUser() throws Exception {
        User user1 = userDao.findUserById(36);
        userDao.deleteUser(36);
        User user2 = userDao.findUserById(36);
        assertEquals(user1,user2);

    }

}