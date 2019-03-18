package com.rpcframework.demo.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * rpc服务暴露和应用公用类
 */
public class RpcFramework {

    /**
     * 服务暴露
     *
     * @param service 需要暴露的服务
     * @param port    暴露的接口
     *                1.创建socket，读出methodName，parameters   new ObjectInputStream(socket.getInputStream())
     *                2.利用反射获取service的method执行
     *                3.利用socket写出数据    new ObjectOutputStream(socket.getOutputStream())
     *                4.记得释放资源！！！
     */
    public static void export(final Object service, int port) throws IOException {
        if (service == null)
            throw new IllegalArgumentException("service instance == null");
        if (port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);
        System.out.println("Export service " + service.getClass().getName() + " on port " + port);
        ServerSocket server = new ServerSocket(port);
        for (; ; ) {
            try {
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            try {
                                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                                try {
                                    String methodName = input.readUTF();
                                    Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                                    Object[] parameters = (Object[]) input.readObject();
                                    Method method = service.getClass().getMethod(methodName, parameterTypes);
                                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                                    try {
                                        Object result = method.invoke(service, parameters);
                                        output.writeObject(result);
                                    } catch (Exception e) {
                                        output.writeObject(e);
                                    } finally {
                                        output.close();  // 关闭输出流
                                    }
                                } finally {
                                    input.close();  // 关闭输入流
                                }
                            } finally {
                                socket.close();  // 关闭socket
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 服务引用
     *
     * @param interfaceClass 接口类型
     * @param host           服务端IP
     * @param port           服务端端口
     * @param <T>            接口泛型
     * @return 服务实现类
     */
    public static <T> T reference(final Class<T> interfaceClass, final String host, final int port) {
        if (interfaceClass == null)
            throw new IllegalArgumentException("Interface class == null");
        if (!interfaceClass.isInterface())
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        if (host == null || host.length() == 0)
            throw new IllegalArgumentException("Host == null!");
        if (port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        try {
            final Socket socket = new Socket(host, port);
            return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    try {
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        try {
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);
                            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                            try {
                                Object result = input.readObject();
                                return result;
                            } finally {
                                input.close();
                            }
                        } finally {
                            output.close();
                        }
                    } finally {
                        socket.close();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
