package com.example.webdemo.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/19 16:17
 * @Description:
 */
@Aspect
@Component
public class AopController {
    /**
     * 定义一个切点
     */
    @Pointcut(value = "execution(* com.example.webdemo.controller.*(..))")
    public void cutOffPoint() {

    }

    @Before("cutOffPoint()")
    public void beforeTest() {
        System.out.println("AOP前置通知");
    }

    @After("cutOffPoint()")
    public void doAfter() {
        System.out.println("AOP后置通知");
    }

    /**
     * @param joinPoint 1.环绕通知可以项目做全局异常处理
     *                  2.日志记录
     *                  3.用来做数据全局缓存
     *                  4.全局的事物处理 等
     * @return
     */
    @Around("cutOffPoint()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕通知");
        Object obj;
        try {
            obj = joinPoint.proceed();
            System.out.println("执行返回值 " + obj);
        } catch (Throwable throwable) {
            obj = throwable.toString();
        }
        return obj;
    }

    @AfterReturning(returning = "result", pointcut = "cutOffPoint()")
    public void doAfterReturning(Object result) throws Throwable {
        System.out.println("doAfterReturning");
    }

    @AfterThrowing(throwing = "e",pointcut = "cutOffPoint()")
    public void doAfterThrowing(Throwable e){
        System.out.println("@AfterThrowing "+e.getMessage());
    }
}
