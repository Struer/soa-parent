package com.soa.user.persistence; 

import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    public Integer login(@Param("userName") String userName, @Param("password") String password);
}
 