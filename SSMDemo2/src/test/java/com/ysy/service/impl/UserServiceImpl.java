package com.ysy.service.impl;

import com.ysy.dao.UserDao;
import com.ysy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//<bean id="userService" class="com.ysy.service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;


    //    <property name="userDao" ref="userDao"></property>
    //自动注入
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao1;
    public void setUserDao1(UserDao userDao) {
        this.userDao1 = userDao;
    }

//    //UserDao的bean是默认单例的，因此，这两次注入的userDao相同
//    @Autowired //按照类型注入
//    @Qualifier("userDao") //按照id值从容器中匹配，必须加上Autowired
//    @Resource相当于 Autowired + Qualifier
    @Resource(name = "userDao")
    private UserDao userDao2;
    public void setUserDao2(UserDao userDao) {
        this.userDao2 = userDao;
    }



    @Override
    public void save() {
        System.out.println(this.userDao1);
        System.out.println(this.userDao2);
        System.out.println(this.driver);
        this.userDao1.save();
    }
}
