package com.itheima.controller;

import com.itheima.domain.Log;
import com.itheima.domain.User;
import com.itheima.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect//表示该类是切面类
public class LogAop {

    @Autowired
    HttpServletRequest request;

    @Autowired
    private LogService logService;
    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        Date start = new Date();//获取方法执行前的时间
        Object proceed = pjp.proceed();//被增强的方法对象
        //获取方法执行后的时间减去方法执行前的时间
        Integer cost = Math.toIntExact(new Date().getTime() - start.getTime());
    //获取目标对象的字节码的名称
        String className = pjp.getTarget().getClass().getName();
        //获取方法名
        String methodName = pjp.getSignature().getName();
      //获取session域中的user对象,
        User user = (User) request.getSession().getAttribute("user");
        String userName = "";
        if (user != null){//判断如果user不等于null,获取user的name
            userName = user.getName();
        }else {//如果user为null,说明登录失败,获取用户输入的name
            userName = request.getParameter("name")+"[登录失败]";
        }

        Log log = new Log();//创建日志对象
        log.setUrl("[类名]"+className+"[方法名]"+methodName);//设置日志属性,访问路径
        log.setName(userName);//访问用户
        log.setCost(cost);//耗时时间
        log.setTime(new Date());//执行时间
        logService.insert(log);//添加到日志中

        return proceed;
    }


}
