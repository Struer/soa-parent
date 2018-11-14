package com.soa.order.domain; 

import java.io.Serializable;


public class Order implements Serializable {
    
   
    private static final long serialVersionUID = -28038289844205259L;
    private Integer id;
    private Integer productId;//产品ID
    private Integer price;//价格
    private Integer userId;//用户账号ID
    private Integer tradeId;//支付id
    private Integer tradeStatus;//支付状态
    private Integer deleted;//删除标志，默认0不删除，1删除
    private String createTime;
    private String updateTime;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getPrice() {
        return price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getTradeId() {
        return tradeId;
    }
    
    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }
    
    public Integer getTradeStatus() {
        return tradeStatus;
    }
    
    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
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

    @Override
    public String toString() {
	return "Order [id=" + id + ", productId=" + productId + ", price=" + price + ", userId=" + userId + ", tradeId=" + tradeId + ", tradeStatus=" + tradeStatus + ", deleted=" + deleted + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }


    
    
}
