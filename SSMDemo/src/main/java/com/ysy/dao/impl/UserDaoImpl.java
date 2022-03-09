package com.ysy.dao.impl;

import com.ysy.dao.UserDao;

public class UserDaoImpl implements UserDao {

    private String userName;
    private int age;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println(age+":"+userName);
        System.out.println("Saving...");
    }
}
