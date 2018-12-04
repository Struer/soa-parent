package com.rpcframework.demo.service;

/**
 * 服务端客户端service接口
 */
public interface UserService {

    /**
     * 根据姓名和地址查询年龄
     * @param name
     * @param adress
     * @return
     */
    int queryAge(String name,String adress);

}
