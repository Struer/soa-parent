package com.rpcframework.demo.server;

import com.rpcframework.demo.common.RpcFramework;
import com.rpcframework.demo.serviceimpl.UserServiceImpl;

import java.io.IOException;

public class Server {

    public static void main(String[] args) throws IOException {
        RpcFramework.export(new UserServiceImpl(), 10002);
    }

}
