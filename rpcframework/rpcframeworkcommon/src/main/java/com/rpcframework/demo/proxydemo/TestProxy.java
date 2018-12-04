package com.rpcframework.demo.proxydemo;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) {

        Person abc = new Student("abc");
        RpcInvocationHandler<Person> handler = new RpcInvocationHandler<>(abc);
        Person person = (Person) Proxy.newProxyInstance(abc.getClass().getClassLoader(), new Class<?>[]{Person.class}, handler);
        person.giveMoney();

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
        String path = "E:/StuProxy.class";
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
//        String path = "E:/$Proxy0.class";
//        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
//        FileOutputStream out = null;
//
//        try {
//            out = new FileOutputStream(path);
//            out.write(classFile);
//            out.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }


}
