package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/login")//通过页面传送过来的用户名和密码,判断是否正确.如果正确就可以登录
   public String login(String name, String password){
        User user = userService.findOne(name, password);//通过用户名和密码查询数据库是否有该用户
        System.out.println(user);
        if (user != null){//如果用户存在,说明已经登录
            //已经登录,把用户存到session域中
            request.getSession().setAttribute("user",user);
            return "redirect:/student/findAll";//重定向到查询所有的方法
        }else {//如果没有查询到用户数据,给出提示信息
            request.setAttribute("msg","用户名或密码错误");
            return "login";//跳转到登录页面
        }
    }
}
