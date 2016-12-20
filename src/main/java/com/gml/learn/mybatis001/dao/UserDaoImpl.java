package com.gml.learn.mybatis001.dao;

import com.gml.learn.mybatis001.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author minglug
 * @date 2016/12/16
 */
public class UserDaoImpl implements UserDao {
    SqlSessionFactory sqlSessionFactory;

    @Override
    public User findUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",id);
        sqlSession.close();
        return user;
    }

   @Override
    public List<User> findUserByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserByName",name);
        sqlSession.close();
        return users;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
    }
}
