package com.ysy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/exception")
@Controller
public class ExceptionTestController {

    @RequestMapping("/error1")
    @ResponseBody
    public String error1(){
        int i = 1/0;
        return "1/0 = " +i;
    }

}
