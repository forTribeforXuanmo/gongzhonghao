package com.zyiot.gongzhonghao.common.Proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017-7-19.
 */
public class InterFaceProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理接口：" + method.getName());
        return method.invoke(proxy, args);
    }

    public static <T> T newInstance(Class<T> innerInterface) {
        ClassLoader classLoader = innerInterface.getClassLoader();
        Class[] interfaces = new Class[]{innerInterface};
        InterFaceProxy proxy = new InterFaceProxy();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }
}
