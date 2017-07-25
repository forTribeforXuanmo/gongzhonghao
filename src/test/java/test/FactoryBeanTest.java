package test;

import com.zyiot.gongzhonghao.common.Proxys.InterFaceProxy;
import com.zyiot.gongzhonghao.common.Proxys.MethodInterceptorImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017-7-19.
 * <p>
 * 自定义通过bean的id获取bean的类，在这里设置了代理，增强了方法，如果上接口使用jdk自身代理，如果不是接口使用cglib
 *
 * @deprecated
 */
public class FactoryBeanTest<T> implements InitializingBean, FactoryBean<T> {
    private String innerClassName;

    public void setInnerClassName(String innerClassName) {
        this.innerClassName = innerClassName;
    }

    @Override
    public T getObject() throws Exception {
        Class innerClass = Class.forName(innerClassName);
        if (innerClass.getInterfaces().length != 0) {
            return (T) Proxy.newProxyInstance(innerClass.getClassLoader(), innerClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("jdk代理接口：" + method.getName());
                    return method.invoke(proxy, args);
                }
            });
        } else {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(innerClass);
            enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    System.out.println("cglib代理的方法拦截：" + method.getName());
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            return (T) enhancer.create();
        }
    }

    @Override
    public Class<?> getObjectType() {

        try {
            return Class.forName(innerClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
