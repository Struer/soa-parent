
package com.soa.order.facade; 

import java.util.List;

import com.soa.order.domain.Order;

public interface OrderFacade {
    public List<Order> findOrderByUserId(Integer userId);
    
    public Integer createOrder(Order obj);
    
    public void updateOrderByTrade(Order obj);
}
 