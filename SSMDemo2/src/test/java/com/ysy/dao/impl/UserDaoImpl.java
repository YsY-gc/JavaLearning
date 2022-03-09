package com.ysy.dao.impl;

import com.ysy.dao.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.ysy.dao.impl.UserDaoImpl"></bean>
//@Component("userDao")
@Repository("userDao")
@Scope("prototype")
//@Scope("singleton")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("Saving...");
    }
}
