package me.ly.project.aop;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Aspect
@Component
@Slf4j
public class WebMapAspect {


    @Pointcut("execution(public * me.ly.project.controller.*.*(..))")
    public void web(){}

    @Around("web()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String jsonStr = getBody(request);
        Gson gson = new Gson();
        Object[] args = proceedingJoinPoint.getArgs();
        Object[] newArgs = new Object[args.length];

        for (int i = 0; i < args.length; i++) {
            newArgs[i] = gson.fromJson(jsonStr, args[i].getClass());
        }

        log.info("jsonStr= {}", jsonStr);
        log.info("args= {}", args);
        log.info("newArgs={}", newArgs);

        return proceedingJoinPoint.proceed(newArgs);

    }
    @Before("web()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("REQ : [{}]{}({})", request.getMethod(), request.getRequestURL().toString(), joinPoint.getSignature().getName());

        log.info("request:{}", getBody(request));
        log.info("REQ : {}", joinPoint.getArgs());

    }

    @AfterReturning(returning = "ret", pointcut = "web()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RES : " + ret);
    }

    private String getBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuffer body = new StringBuffer();
        String input;
        while ((input = reader.readLine()) != null) {
            body.append(input);

        }
        return body.toString();
    }

}