package com.zero.spring.annotaions.common.aspect;

import com.zero.spring.annotaions.common.util.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class RequestTimeAspect {

    @Pointcut(value = "@annotation(com.zero.spring.annotaions.common.annotations.RequestTime)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
		Method currentMethod = AspectUtil.getMethod(point);
		long startTime = System.currentTimeMillis();
		Object result = point.proceed();
		long endTime = System.currentTimeMillis();
		long requestTime =endTime-startTime;
//        if (requestTime > 1000) {
            String message = String.format("%s.%s execute time：%s ms", AspectUtil.getClassName(point), currentMethod.getName(), requestTime);
            log.info(message);
//        }
        return result;
    }
}
