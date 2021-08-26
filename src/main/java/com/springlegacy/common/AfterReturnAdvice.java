package com.springlegacy.common;

import com.springlegacy.model.user.UserVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturnAdvice {

    Logger Log = LoggerFactory.getLogger(AfterReturnAdvice.class);

    @Pointcut("execution(* com.springlegacy..*Impl.get*(..))")
    public void getPointCut(){}

    @AfterReturning(pointcut = "getPointCut()",returning = "returnObj")
    public void afterLog(JoinPoint jp, Object returnObj){
        String method = jp.getSignature().getName();
        if(returnObj instanceof UserVO){
            UserVO user = (UserVO) returnObj;
            Log.info(user.getId() + "님");
        }
        Log.info("[사후 처리] " + method + "() 메소드 리턴값: " + returnObj.toString());
    }
}
