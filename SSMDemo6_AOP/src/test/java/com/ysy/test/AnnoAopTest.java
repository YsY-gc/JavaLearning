package com.ysy.test;

import com.ysy.anno_aop.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class AnnoAopTest {

    @Autowired
    private Target target;

    @Test
    public void test1(){
        target.save();
    }

}
