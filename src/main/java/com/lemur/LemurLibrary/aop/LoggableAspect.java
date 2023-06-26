package com.lemur.LemurLibrary.aop;

import com.lemur.LemurLibrary.logging.LemurLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Configurable
@Aspect
@Component
public class LoggableAspect {
    @Autowired
    Environment env;

    private LemurLogger logger;
    private LoggableAspect() throws IOException {
        logger = new LemurLogger();
    }

    @AfterReturning(pointcut = "@annotation(Loggable)", returning = "object")
    private void log(JoinPoint joinPoint, Object object) {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String activeProfile = env.getActiveProfiles()[0];
        for (int i=0; i<codeSignature.getParameterNames().length;i++) {
            logger.log("Method "+signature.getMethod().getName()+" called with argument name:"+codeSignature.getParameterNames()[i] + " with value:"+joinPoint.getArgs()[i],activeProfile);
        }
    }
}
