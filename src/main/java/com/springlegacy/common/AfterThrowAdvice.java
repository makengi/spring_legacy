package com.springlegacy.common;

import com.springlegacy.model.user.exception.BlockUserException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowAdvice {
    private static Logger Log = LoggerFactory.getLogger(AfterThrowAdvice.class);

    @Pointcut("execution(* com.springlegacy.model.user.impl.UserServiceImpl.*(..))")
    public void allPointCut(){
        Log.info("allPointcut()");
    }

    @AfterThrowing(pointcut = "allPointCut()",throwing = "exceptObject")
    public void exceptionLog(JoinPoint jp, Exception exceptObject){
        String method = jp.getSignature().getName();
        Log.info("[예외] "+ method +"() 메소드 수행중 발생된 에러 메세지: "+exceptObject.getMessage());
        if(exceptObject instanceof BlockUserException){
            Log.info("차단된 사용자가 접근하였습니다.");
        }
    }
}
