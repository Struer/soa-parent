package com.soa.product.facade; 

import java.util.List;

import javax.annotation.Resource;

import com.soa.product.domain.Product;
import com.soa.product.service.ProductService;



public class ProductFacadeImpl implements ProductFacade{

    @Resource
    private ProductService productService;
    
    @Override
    public List<Product> findAllProduct() {
	return this.productService.findAllProduct();
    }



}
 