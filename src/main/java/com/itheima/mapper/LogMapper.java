package com.itheima.mapper;

import com.itheima.domain.Log;
import org.apache.ibatis.annotations.Insert;

public interface LogMapper {
     //添加日志信息
    @Insert("insert into t_log (id,name,time,url,cost) values(#{id},#{name},#{time},#{url},#{cost})")
    public void insert(Log log);
}
