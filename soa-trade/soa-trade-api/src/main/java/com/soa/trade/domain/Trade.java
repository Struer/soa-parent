package com.soa.trade.domain; 

import java.io.Serializable;


public class Trade implements Serializable{
    private static final long serialVersionUID = 1515761158105456152L;
    private Integer id;
    private Integer orderId;//订单ID
    private Integer userId;//用户ID
    private Integer price;//支付价
    private Integer payStatus;//1 未付款 2 付款中 3 付款失败 4 付款完成
    private Integer payType;//支付类型:1-支付宝支付，2-网银在线，3-银联，4-微信支付
    
    private String gatewayPayNum;//网关支付流水号
    private String gatewayPayTime;//网关支付时间
    private Integer gatewayPayPrice;//网关实际支付金额
    
    private Integer deleted;//删除标志，默认0不删除，1删除
    private String createTime;
    private String updateTime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getPrice() {
        return price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public Integer getPayStatus() {
        return payStatus;
    }
    
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
    
    public Integer getPayType() {
        return payType;
    }
    
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    
    public String getGatewayPayNum() {
        return gatewayPayNum;
    }
    
    public void setGatewayPayNum(String gatewayPayNum) {
        this.gatewayPayNum = gatewayPayNum;
    }
    
    public String getGatewayPayTime() {
        return gatewayPayTime;
    }
    
    public void setGatewayPayTime(String gatewayPayTime) {
        this.gatewayPayTime = gatewayPayTime;
    }
    
    public Integer getGatewayPayPrice() {
        return gatewayPayPrice;
    }
    
    public void setGatewayPayPrice(Integer gatewayPayPrice) {
        this.gatewayPayPrice = gatewayPayPrice;
    }
    
    public Integer getDeleted() {
        return deleted;
    }
    
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    
    
}
 