package com.itheima.service.impl;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void add(Student student) {
        studentMapper.add(student);
    }

    @Override
    public Student findOne(Integer id) {
        return studentMapper.findOne(id);
    }

    @Override
    public void update(Student student) {
           studentMapper.update(student);
    }

    @Override
    public void del(Integer[] ids) {
        studentMapper.del(ids);
    }
}
