package com.ysy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysy.domain.User;
import com.ysy.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value="/quickstart", method = RequestMethod.GET,params = {})
    public String save(){
        System.out.println("Controller saving...");
        return "success.jsp";
    }

    @RequestMapping(value="/quickstart2", method = RequestMethod.GET,params = {})
    public ModelAndView save2(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success.jsp");
        modelAndView.addObject("username", "zhangsan");

        return modelAndView;
    }

    @RequestMapping(value="/quickstart3", method = RequestMethod.GET,params = {})
    public ModelAndView save3(ModelAndView modelAndView){

        modelAndView.setViewName("success.jsp");
        modelAndView.addObject("username", "zhangsan");

        return modelAndView;
    }

    @RequestMapping(value="/quickstart4", method = RequestMethod.GET,params = {})
    public String save4(Model model){

        model.addAttribute("username", "杨书印");

        return "success.jsp";
    }

    @RequestMapping(value="/quickstart6", method = RequestMethod.GET,params = {})
    public void save6(HttpServletResponse resp) throws IOException {
        resp.getWriter().print("hello world");
    }

    @RequestMapping(value="/quickstart7", method = RequestMethod.GET,params = {})
    @ResponseBody //告知springmvc框架，不进行视图跳转，直接进行数据响应
    public String save7() throws IOException {
        return "hello world";
    }

    @RequestMapping(value="/quickstart9", method = RequestMethod.GET,params = {})
    @ResponseBody //告知springmvc框架，不进行视图跳转，直接进行数据响应
    public String save9() throws IOException {
        User user  = new User();
        user.setUsername("zhangsan");
        user.setAge(18);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping("/quickstart10")
    @ResponseBody
    //希望SpringMVC自动将返回的User对象转换为json格式  因此需要进行spring-mvc.xml配置，修改处理器适配器配置
    public User save10(){
        User user  = new User();
        user.setUsername("zhangsan");
        user.setAge(18);

        return user;
    }

    //http://localhost:8080/mvc/quickstart11?username=zhangsan&age=20
    @RequestMapping("/quickstart11")
    @ResponseBody
    public void save11(String username, int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quickstart12")
    @ResponseBody
    //封装pojo
    public void save12(User user){
        System.out.println(user);
    }

    @RequestMapping("/quickstart14")
    @ResponseBody
    //封装pojo
    public void save14(VO vo){
        System.out.println(vo);
    }

    @RequestMapping("/quickstart15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList){
        System.out.println(userList);
    }

}
