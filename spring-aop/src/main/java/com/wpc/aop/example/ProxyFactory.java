package com.wpc.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wpc
 * @date 2023/10/13 14:06
 */
public class ProxyFactory {
    //目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回代理对象
    public Object getProxy(){
        /**
         * Proxy.newProxyInstance() 有三个参数
         *  ClassLoader:加载动态生成代理类的代理器
         *  interfaces:目标对象实现的的所有接口的class数组
         *  InvocationHandler:设置代理对象实现目标对象方法的过程
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * @param proxy 代理对象
             * @param method 需要重写目标对象的方法
             * @param args 对应方法的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("日志。。。方法调用之前");
                //调用目标方法
                Object result = method.invoke(target,args);
                System.out.println("日志。。。方法调用之后");
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
