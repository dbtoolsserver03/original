package com.baizhi.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义切面配置类
 */
@Configuration //代表当前这个类是一个spring的配置类
@Aspect  //代表这个类是一个切面配置类
public class MyAspectConfig {



    //切面Aspect = Advice 附加操作 + Pointcut切入点

    //切入点表达式:
    // 1.execution 方法级别切入点表达式 save update 运行效率越低
    // 2.within:类级别切入点表达式: 控制越粗 运行效率
    // 3.基于注解的切入点表达式 @annotation(com.baizhi.annotations.xxx)

    //@Around("execution(* com.baizhi.service.*.*(..))")
    //@Around("within(com.baizhi.service.*)")
    @Around("@annotation(com.baizhi.annotations.MyAdvice)")
    // 返回值作用: 用来讲业务方法返回结果返回给调用者
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("==========进入环绕的前置操作===========");
        System.out.println("当前执行类: "+proceedingJoinPoint.getTarget());
        System.out.println("方法名: "+proceedingJoinPoint.getSignature().getName());
        //放心目标方法执行
        Object proceed = proceedingJoinPoint.proceed();//继续处理  业务逻辑方法执行
        System.out.println("==========进入环绕的后置操作===========");
        return proceed;
    }


    //@Before("execution(* com.baizhi.service.*.*(..))") //@Before 代表这是一个核心业务逻辑执行之前附加操作  value:用来书写切入点表达式 配置附加操作在哪里生效
    //public void before(JoinPoint joinPoint){
    //    System.out.println("=========前置附加操作=========");
    //    System.out.println("当前执行目标类: "+ joinPoint.getTarget());
    //    System.out.println("当前执行目标类中方法: "+ joinPoint.getSignature().getName());
    //}
    //
    //
    //@After("execution(* com.baizhi.service.*.*(..))")
    //public void after(JoinPoint joinPoint){
    //    System.out.println("========后置附加操作==========");
    //    System.out.println("当前执行目标类: "+ joinPoint.getTarget());
    //    System.out.println("当前执行目标类中方法: "+ joinPoint.getSignature().getName());
    //}





}
