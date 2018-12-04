package com.rpcframework.demo.proxydemo;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RpcInvocationHandler<T> implements InvocationHandler {
    T target;

    public RpcInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行了");
        Object invoke = method.invoke(target, args);
//        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", Student.class.getInterfaces());
//        String path = "E:/StuProxy.class";
//        try (FileOutputStream fos = new FileOutputStream(path)) {
//            fos.write(classFile);
//            fos.flush();
//            System.out.println("代理类class文件写入成功");
//        } catch (Exception e) {
//            System.out.println("写文件错误");
//        }
        return invoke;
    }
}
