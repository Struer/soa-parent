package com.soa.trade.service; 



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soa.trade.domain.Trade;
import com.soa.trade.persistence.TradeMapper;

@Service
public class TradeService {
    
    @Resource
    private TradeMapper tradeMapper;
    

    
    public void createTrade(Trade obj){
	this.tradeMapper.insert(obj);
    }
    
    
}
 