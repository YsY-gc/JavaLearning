package com.ysy.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysy.domain.User;
import com.ysy.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class ServiceTestDemo {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
//        user.setPassword("123");


        List<User> userList = mapper.findUserByCondition(user);
        System.out.println(userList);
        sqlSession.close();
    }


    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<User> userList = mapper.findUserByIds(ids);
        System.out.println(userList);
        sqlSession.close();

    }

    @Test
    //测试分页插件
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        //设置分页相关参数
        PageHelper.startPage(1,3);


        List<User> userList = mapper.findAll();

        PageInfo<User> info = new PageInfo<>(userList);

        //获取当前页码
        System.out.println(info.getPageNum());

        for(User user:userList){
            System.out.println(user);
        }

        sqlSession.close();


    }


}
