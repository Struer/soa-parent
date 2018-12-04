package com.rpcframework.demo.proxydemo;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class ProxyGeneratorUtils {

    byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());

}
