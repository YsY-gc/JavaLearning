package com.ysy.com.ysy.dao;

public interface AcountDao {

    void out(String username1, int money);

    void in(String username2, int money);
}
