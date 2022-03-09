package com.ysy.test;

import com.ysy.config.SpringConfiguration;
import com.ysy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 集成 JUnit，测试更方便
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringJunitTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.save();
    }
}
