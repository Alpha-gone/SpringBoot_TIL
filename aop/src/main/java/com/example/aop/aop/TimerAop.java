package com.example.aop.aop;

import com.example.aop.model.UserRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
public class TimerAop {

    @Pointcut(value = "within(com.example.aop.controller.UserApiController)")
    public void timerPointCut(){}

    @Before("timerPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
    }

    @After("timerPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }

    @AfterReturning(value = "timerPointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("after returning");
    }


    @AfterThrowing(value = "timerPointCut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable){
        System.out.println("after throwing");
    }


    @Around("timerPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메소드 실행 이전");

        Arrays.stream(joinPoint.getArgs()).forEach(
               arg -> {
                   if(arg instanceof UserRequest){
                       var tempUser = (UserRequest)arg;
                       var phoneNumber = tempUser.getPhoneNumber().replace("-", "");

                       tempUser.setPhoneNumber(phoneNumber);
                   }
               }
        );

        var newObjs = Arrays.asList(new UserRequest());

        var stopWatch = new StopWatch();

        stopWatch.start();

        joinPoint.proceed(newObjs.toArray());

        stopWatch.stop();

        System.out.println("총 소요 시간 MS = " + stopWatch.getTotalTimeMillis());
        System.out.println("메소드 실행 이후");
    }
}
