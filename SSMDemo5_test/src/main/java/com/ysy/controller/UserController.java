package com.ysy.controller;

import com.ysy.domain.Role;
import com.ysy.domain.User;
import com.ysy.service.RoleService;
import com.ysy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;



    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();

        List<User> userList = userService.list();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    @RequestMapping("/addUI")
    public ModelAndView addUI(){
        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");

        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds){

        userService.save(user, roleIds);

        return "redirect:/user/list";

    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
        userService.del(userId);
        return "redirect:/user/list";
    }

}
