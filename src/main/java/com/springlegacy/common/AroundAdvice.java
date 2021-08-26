package com.springlegacy.common;


import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class AroundAdvice {

    private Logger Log = LoggerFactory.getLogger(AroundAdvice.class);

    public Object aroungLog(ProceedingJoinPoint pjp) throws Throwable{

        String method = pjp.getSignature().getName();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object obj = pjp.proceed();

        stopWatch.stop();

        Log.info(method + "() 메소드 수행에 걸린시간: " + stopWatch.getTotalTimeMillis() + "(ms)초");
        return obj;
    }
}
