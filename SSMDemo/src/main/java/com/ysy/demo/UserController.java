package com.ysy.demo;

import com.ysy.service.UserService;
import com.ysy.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService) app.getBean("userService");
        UserService userService = app.getBean(UserService.class);
        userService.save();


//        UserServiceImpl userService = new UserServiceImpl(); //NullPointerException 异常
//        userService.save();
    }

}
