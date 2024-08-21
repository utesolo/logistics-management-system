package com.lynz.logisticsmanagementsystem.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author lynz
 */
@Aspect
@Component
public class AuthAspect {

    private static final Logger log = LoggerFactory.getLogger(AuthAspect.class);

    @Pointcut("@annotation(com.lynz.logisticsmanagementsystem.AOP.auth)")
    public void pointCut() {

    }

    @Before("execution(* com.lynz.logisticsmanagementsystem.controller.UserController.getProfile(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        log.info("Executing method: {}", joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("Argument: {}", arg);
        }

        // 获取方法返回类型
        Class<?> returnType = joinPoint.getSignature().getDeclaringType();
        log.info("Return type: {}", returnType);
        if (returnType.equals(String.class)) {
            // 如果返回类型是 String，我们可以假设它是 profile
            log.info("Expected to return a String (profile)");
        }
    }
}
