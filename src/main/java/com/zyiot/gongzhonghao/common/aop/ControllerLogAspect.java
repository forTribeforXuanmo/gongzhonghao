package com.zyiot.gongzhonghao.common.aop;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.toolkit.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2017-7-11.
 */
@Aspect
@Component
public class ControllerLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

    @Pointcut("within(com.zyiot.gongzhonghao.controller..*)")
    public void inController() {
    }

    @Pointcut("execution(public * com.zyiot.gongzhonghao.controller..*.*(..))")
    public void controller() {
    }

    public void writeBeforeLog(JoinPoint jp) {
        this.debugInController(jp, "Start");
    }


    public void writeAfterLog(JoinPoint jp) {
        this.debugInController(jp, "End");
    }

    @Around("inController()")
    public Object around(ProceedingJoinPoint jp) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        signature.getMethod();
        //方法名字
        String signatyreName = signature.getName();
        //参数列表
        Object[] args = jp.getArgs();
        //方法所在的类名
        String declaringTypeName = signature.getDeclaringTypeName();
        String returnType = signature.getReturnType().getSimpleName();
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            logger.info("--------------开始日志---------------   ");
            String reqStr = "";
            if (args.length == 2 && args[0] instanceof HttpServletRequest) {
                HttpServletRequest req = (HttpServletRequest) args[0];
                HttpServletResponse resp = (HttpServletResponse) args[1];
                Map reqMap = req.getParameterMap();
                reqStr = "Request:" + JSON.toJSONString(reqMap);
            } else {
                reqStr = JSON.toJSONString(args);
            }
            logger.info("调用服务:" + declaringTypeName + "." + signatyreName + "的入参为：" + reqStr);
            result = jp.proceed();
        } catch (Throwable e) {
            logger.error("aop异常 :" + declaringTypeName + "." + signatyreName + " params:" + JSON.toJSONString(args));
            logger.error("异常：" + e);
        } finally {
            long endTime = System.currentTimeMillis();
            logger.info("调用服务:" + declaringTypeName + "." + signatyreName + "总时间:" + (endTime - startTime));
            logger.info("出参:  类型> " + JSON.toJSONString(returnType) + " 结果——》" + result);
            logger.info("--------------结束日志---------------");
            return result;
        }
    }

    private void debugInController(JoinPoint jp, String msg) {
        String userName = getLoginUserName();
        this.logger.debug("\n【{}】{}.{}() {} ", userName,
                jp.getTarget()
                        .getClass().getSimpleName(), jp.getSignature().getName(), msg);
    }

    private static String getLoginUserName() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return "Anonymous";
    }

    public void writeParams(JoinPoint jp) {
        String[] names = ((CodeSignature) jp.getSignature())
                .getParameterNames();
        Object[] args = jp.getArgs();

        if (ArrayUtils.isEmpty(names)) {
            return;
        }

        StringBuilder sb = new StringBuilder("Arguments: ");
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i] + " = " + args[i] + ",");
        }

        debugInController(jp, sb.toString());
    }
}
