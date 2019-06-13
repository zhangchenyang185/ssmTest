package com.itheima.controller;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")//一级映射
public class StudentController {
    @Autowired//注入
    private StudentService studentService;
    @RequestMapping("/findAll")//二级映射
    public ModelAndView findAll(){ //查询所有学生
        ModelAndView modelAndView = new ModelAndView();//定义视图模型
        List<Student> studentList = studentService.findAll();//调用方法,查询所有学生
        modelAndView.addObject("studentList",studentList);//添加到request域中
        modelAndView.setViewName("list");//跳转到list页面
        return modelAndView;//返回视图模型
    }

    @RequestMapping("/add")//添加方法
    public String add(Student student){
        studentService.add(student);//调用方法,完成添加逻辑
        return "redirect:/student/findAll";//重定向到查询所有的方法
    }

    @RequestMapping("/findOne")//查询单个对象,回显到修改界面
    public ModelAndView findOne(Integer id){//通过id查询用户
        ModelAndView modelAndView = new ModelAndView();//定义视图模型
        Student student = studentService.findOne(id);//调用方法,通过id查询用户
        modelAndView.addObject("student",student);//保存到request域中
        modelAndView.setViewName("update");//跳转到update页面
        return modelAndView;//返回
    }

    @RequestMapping("/update")//修改方法
    public String update(Student student){
        studentService.update(student);
        return "redirect:/student/findAll";//重定向到查询所有的方法
    }

    @RequestMapping("/del")//删除方法
    public String del(Integer[] ids){//定义一个数组,用于接收参数,可以删除单个也可以删除多个
        studentService.del(ids);//调用删除方法,完成操作
        return "redirect:/student/findAll";//重定向到查询所有的方法
    }


}
