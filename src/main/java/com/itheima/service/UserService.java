package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {

    //根据用户名和密码查询用户是否登录
    public User findOne(String name,String password);

}
