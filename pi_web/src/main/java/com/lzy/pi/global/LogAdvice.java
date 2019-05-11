package com.lzy.pi.global;


import com.lzy.pi.entity.Log;
import com.lzy.pi.entity.Staff;
import com.lzy.pi.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LogAdvice {
    @Autowired
    private LogService logService;

    @After("execution(* com.lzy.pi.controller.*.*(..)) && !execution(* com.lzy.pi.controller.SelfController.*(..))&& !execution(* com.lzy.pi.controller.SelfController.*.to*(..))")
    public void operationLog(JoinPoint joinPoint){
        Log log = new Log();
        //当前要增强的目标对象的类的方法名
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff=(Staff)obj;
        log.setOperator(staff.getAccount());
        log.setResult("成功");
        //存到操作日志
        logService.addOperationLog(log);

    }



    @AfterThrowing(throwing = "e",pointcut = "execution(* com.lzy.pi.controller.*.*(..)) && !execution(* com.lzy.pi.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log = new Log();
        //当前要增强的目标对象的类的方法名
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff=(Staff)obj;
        log.setOperator(staff.getAccount());
        //拿到异常对象获取类、获取类名、存入系统日志
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);

    }

    @After("execution(* com.lzy.pi.controller.SelfController.login(..)) ")
    public void loginLog(JoinPoint joinPoint){
        log(joinPoint);
    }


    @Before("execution(* com.lzy.pi.controller.SelfController.logout(..)) ")
    public void logoutLog(JoinPoint joinPoint){
        log(joinPoint);
    }


    private void log(JoinPoint joinPoint){
        Log log = new Log();
        //当前要增强的目标对象的类的方法名
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        if(obj==null){
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        }else {
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("成功");

        }
        //存到登录日志
        logService.addLoginLog(log);
    }
}
