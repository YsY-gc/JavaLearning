package com.ysy.anno_aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Before("execution(* com.ysy.anno_aop.*.*(..))")
    public void before(){
        System.out.println("前置增强...");
    }
}
