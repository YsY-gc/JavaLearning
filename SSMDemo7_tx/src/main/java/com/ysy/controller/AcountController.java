package com.ysy.controller;

import com.ysy.service.AcountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AcountController {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AcountService acountService = app.getBean(AcountService.class);
        acountService.transfer("zhangsan", "lisi", 500);

    }
}
