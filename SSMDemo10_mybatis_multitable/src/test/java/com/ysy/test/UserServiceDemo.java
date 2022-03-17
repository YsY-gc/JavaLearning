package com.ysy.test;

import com.ysy.domain.User;
import com.ysy.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceDemo {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        List<User> userList = userMapper.findUserAndRoleAll();
        for (User user : userList) {
            System.out.println(user);
        }
//        System.out.println(userList);
//        sqlSession.close();
    }

}
