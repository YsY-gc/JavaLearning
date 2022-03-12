package com.ysy.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void testUpdate(){

        int row = jdbcTemplate.update("insert into users values(?,?)", "zhaoliu", 16);
        System.out.println(row);

    }

}
