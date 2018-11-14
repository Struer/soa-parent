package com.soa.product.domain; 

import java.io.Serializable;


public class Product implements Serializable{
    


    private static final long serialVersionUID = 3179166109028634763L;
    private Integer id;
    private String name;//产品名称
    private Integer status;//产品状态：0待审，1上架，2下架，3停售，4测试
    private Integer price;//产品价格 单位分 
    private String detail;//产品详情
    private Integer deleted;//删除标志，默认0不删除，1删除
    private String createTime;
    private String updateTime;
    
    public Integer getId() {
        return id;
    }
    
    
    public Integer getPrice() {
        return price;
    }

    
    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getDetail() {
        return detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
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
 