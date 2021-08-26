package com.springlegacy.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Component
@Aspect
public class LogAdvice {

    private static Logger Log = LoggerFactory.getLogger(LogAdvice.class);

    @Pointcut("execution(* com.springlegacy.model..*DAO.*(..))")
    public void allPointCut(){}


    @Before("allPointCut()")
    public void printLog(JoinPoint jp){
        String method = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        Log.info("[공통 로그] 비지니스 로직 수행 전 동작" + method + "() 메소드 ARGS 정보: "+ args[0].toString());
    }
}
