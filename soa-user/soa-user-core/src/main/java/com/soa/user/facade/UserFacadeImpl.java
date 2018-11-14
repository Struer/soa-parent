package com.soa.user.facade; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soa.user.service.UserService;


@Service
public class UserFacadeImpl implements UserFacade{

    @Resource
    private UserService userService;
    
    @Override
    public Integer login(String userName,String password) {
	return this.userService.login(userName, password);
    }



}
 