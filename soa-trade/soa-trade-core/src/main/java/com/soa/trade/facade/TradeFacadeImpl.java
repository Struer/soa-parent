package com.soa.trade.facade; 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soa.order.domain.Order;
import com.soa.order.facade.OrderFacade;
import com.soa.trade.domain.Trade;
import com.soa.trade.service.TradeService;


@Service
public class TradeFacadeImpl implements TradeFacade{

    @Resource
    private TradeService tradeService;
    
    @Resource
    private OrderFacade orderFacade;
    
    public void createTrade(Trade obj){
	this.tradeService.createTrade(obj);
	
	Order order=new Order();
	order.setId(obj.getOrderId());
	order.setTradeId(obj.getId());
	this.orderFacade.updateOrderByTrade(order);
    }



}
 