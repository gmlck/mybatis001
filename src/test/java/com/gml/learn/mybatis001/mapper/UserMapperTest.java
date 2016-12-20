package com.gml.learn.mybatis001.mapper;

import com.gml.learn.mybatis001.dao.UserDao;
import com.gml.learn.mybatis001.dao.UserDaoImpl;
import com.gml.learn.mybatis001.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.ValidateWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author minglug
 * @date 2016/12/20
 */
public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    UserMapper userMapper;
    @Before
    public void setUp() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config/SqlMapConfig.xml"));
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void findUserById() throws Exception {
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void findUserByName() throws Exception {
        List<User> users =  userMapper.findUserByName("%小明%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void insertUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }

    @After
    public void setOff() {
        sqlSession.close();
    }

}