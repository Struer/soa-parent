package com.rpcframework.demo.serviceimpl;

import com.rpcframework.demo.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public int queryAge(String name, String adress) {
        if ("xiaoming".equals(name) && "shanghai".equals(adress)){
            return 18;
        }
        return 0;
    }
}
