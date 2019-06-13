package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface UserMapper {

    //通过name和password查询用户是否存在
    @Select("select * from t_user where name=#{name} and password = #{password}")
    public User findOne(@Param("name") String name, @Param("password") String password);

}
