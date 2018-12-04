package com.rpcframework.demo.client;

import com.rpcframework.demo.common.RpcFramework;
import com.rpcframework.demo.service.UserService;

public class Client {

    public static void main(String[] args) {
        int age = 0;
        for (int i = 0; i < 10; i++) {
            UserService userService = RpcFramework.reference(UserService.class, "127.0.0.1", 10002);
            age = userService.queryAge("xiaoming", "shanghai");
            System.out.println(age);
        }
    }

}
