package com.gml.learn.mybatis001.first;

import com.gml.learn.mybatis001.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * <p>Description:</p>
 *
 * @author minglug
 * @date 2016/12/14
 */
public class MybatisFirstTest {
    String resource = "config/SqlMapConfig.xml";
    java.io.InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;

    public MybatisFirstTest() throws IOException {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserByIdTest() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",30);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void findUserByNameTest() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("test.findUserByName","%小明%");
        list.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void insertUserTest() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("王小军");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("河南郑州");
        sqlSession.insert("insertUser", user);
        sqlSession.commit();
        System.out.println(user.getId());
        sqlSession.close();
    }
    @Test
    public void deleteUserTest() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("deleteUser",29);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUserTest() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User u = new User();
        u.setId(30);
        u.setUsername("王大军");
        u.setSex("2");
        sqlSession.update("updateUser",u);
        sqlSession.commit();
        sqlSession.close();
    }
}
