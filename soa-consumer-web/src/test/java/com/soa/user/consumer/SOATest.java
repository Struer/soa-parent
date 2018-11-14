package com.soa.user.consumer;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soa.order.domain.Order;
import com.soa.order.facade.OrderFacade;
import com.soa.product.domain.Product;
import com.soa.product.facade.ProductFacade;
import com.soa.trade.domain.Trade;
import com.soa.trade.facade.TradeFacade;
import com.soa.user.facade.UserFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/xml/all.xml")
public class SOATest {

    @Resource
    private ProductFacade productFacade;
    
    @Resource
    private UserFacade userFacade;
    
    @Resource
    private OrderFacade orderFacade;
    
    @Resource
    private TradeFacade tradeFacade;

    @Test
    public void batchTest(){
	for(int i=0;i<10;i++){
	    this.test();
	}
    }
    
    @Test
    public void test(){
	Integer userid = this.login();
	List<Product> products = productFacade.findAllProduct();
	for (Product obj : products) {
	    System.out.println(obj.getName());
	}
	
	Product product = products.get(0);
	Order order = new Order();
	order.setUserId(userid);
	order.setProductId(product.getId());
	order.setPrice(product.getPrice());
	Integer orderId=this.orderFacade.createOrder(order);
	
	
	Trade trade=new Trade();
	trade.setUserId(order.getUserId());
	trade.setOrderId(orderId);
	trade.setPrice(order.getPrice());
	
	trade.setPayType(1);//支付类型:1-支付宝支付，2-网银在线，3-银联，4-微信支付
	trade.setPayStatus(4);//1 未付款 2 付款中 3 付款失败 4 付款完成
	
	trade.setGatewayPayNum("pay00000000001");
	trade.setGatewayPayPrice(order.getPrice());
	trade.setGatewayPayTime("2016-3-3 12:02:55");
	
	
	this.tradeFacade.createTrade(trade);
	
	
	List<Order> orders=this.orderFacade.findOrderByUserId(userid);
	for(Order obj:orders){
	    System.out.println(obj);
	}
    }
    
    private Integer login() {
	String userName = "admin";
	String password = "admin";
	Integer id = this.userFacade.login(userName, password);
	if (id != null) {
	    System.out.println("登录成功 id=" + id);
	} else {
	    System.out.println("登录失败");
	}
	return id;
    }

}
