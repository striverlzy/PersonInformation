package com.lzy.pi.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 核心控制器
 */
public class DispatcherServlet extends GenericServlet {

    private ApplicationContext context;

    public void init() throws ServletException{
        super.init();
        context =  new ClassPathXmlApplicationContext("spring.xml");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //得到用户请求的url，但是ServletRequest的参数是servletRequest是没办法拿到请求路径，因此要进行强转
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;

        //规范实际开发的规则
        /*
            staff/add.do   login.do
            staffController
            public void add (HttpServletRequest request,HttpServletResponse response){}
         *
         */

        //首先获取用户请求的url
        String path = request.getServletPath().substring(1);
        //获取IOC容器Bean的名字,另外是对应处理请求的方法名
        String beanName=null;
        String methodName=null;
        //判断是哪种请求  staff/add.do   login.do
        int index = path.indexOf('/');
        //判断“staff/add.do”
        if(index !=-1){
            beanName = path.substring(0,index)+"Controller";
            methodName = path.substring(index+1,path.indexOf(".do"));
        }else {
            //判断 "login.do"
            beanName = "selfController";
            methodName = path.substring(0,path.indexOf(".do"));
        }

        //要想访问ioc容器，首先要获取context上下文
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //获取Bean
        Object obj = context.getBean(beanName);
        //获取方法名
        try {
            Method method = obj.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //调用方法

            method.invoke(obj,request,response);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
