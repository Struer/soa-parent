package com.soa.order.service; 



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soa.order.domain.Order;
import com.soa.order.persistence.OrderMapper;

@Service
public class OrderService {
    
    @Resource
    private OrderMapper orderMapper;
    
    public List<Order> findOrderByUserId(Integer userId){
	return this.orderMapper.findOrderByUserId(userId);
    }
    
    public void createOrder(Order obj){
	this.orderMapper.insert(obj);
    }
    
    public void updateOrderByTrade(Order obj){
	this.orderMapper.updateOrderByTrade(obj);
    }
    
}
 