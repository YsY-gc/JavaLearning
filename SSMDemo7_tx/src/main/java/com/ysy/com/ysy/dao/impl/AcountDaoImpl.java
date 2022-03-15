package com.ysy.com.ysy.dao.impl;

import com.ysy.com.ysy.dao.AcountDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class AcountDaoImpl implements AcountDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void out(String username1, int money) {

        jdbcTemplate.update("update acount set money=money-? where username=?",money,username1);

    }

    @Override
    public void in(String username2, int money) {
        jdbcTemplate.update("update acount set money=money+? where username=?",money,username2);
    }
}
