package com.itheima.service;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentService {

    //查询所有学生
    public List<Student> findAll();

    //添加学生
    public void add(Student student);

    //通过id查询一个学生
    public Student findOne(Integer id);

    //修改学生
    public void update(Student student);

    //删除学生,通用,单个删除和批量删除都可以
    public void del(Integer[] ids);
}
