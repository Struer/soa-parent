package com.soa.order.persistence; 

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soa.order.domain.Order;


public interface OrderMapper {
    public List<Order> findOrderByUserId(@Param("userId")Integer userId);
    public void insert(Order obj);
    
    public void updateOrderByTrade(Order obj);
}
 