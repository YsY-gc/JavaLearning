package com.ysy.resolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView modelAndView = new ModelAndView();

        if(ex instanceof ClassCastException){
            modelAndView.addObject("info", "类型转换异常");
        }else {
            modelAndView.addObject("info", "其他异常");
        }
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
