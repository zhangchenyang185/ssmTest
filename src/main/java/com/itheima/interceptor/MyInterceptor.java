package com.itheima.interceptor;

import com.itheima.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//自定义拦截器,控制用户是否登录
public class MyInterceptor implements HandlerInterceptor {

    @Override//在执行方法之前执行的方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();//获取session对象
        User user = (User) session.getAttribute("user");//获取session域找那个的user对象
        if (user != null){//如果有值,说明已经登录,直接放行
            //已经登录,可以访问
            return true;
        }
        //否则,说明没有登录,跳转到错误页面,给出提示信息
       response.sendRedirect(request.getContextPath()+"/denied.jsp");
        return false;//不放行
    }
}
