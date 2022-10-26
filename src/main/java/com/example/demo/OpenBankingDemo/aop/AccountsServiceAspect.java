package com.example.demo.OpenBankingDemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountsServiceAspect {
    @Before(value = "execution(* com.example.demo.OpenBankingDemo.accounts.AccountServiceImpl.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("This is to be printed before the AccountServiceImpl will be called");
    }

    @After(value = "execution(* com.example.demo.OpenBankingDemo.accounts..AccountServiceImpl.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("This is to be printed after the AccountServiceImpl got called");
    }

    @AfterReturning(value = "execution(* com.example.demo.OpenBankingDemo.accounts..AccountServiceImpl.*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint) {
        System.out.println("This is to be printed afterReturning AccountServiceImpl got called");
    }
}
