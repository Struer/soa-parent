package com.soa.product.service; 



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soa.product.domain.Product;
import com.soa.product.persistence.ProductMapper;

@Service
public class ProductService {
    
    @Resource
    private ProductMapper productMapper;
    
    public List<Product> findAllProduct(){
	return this.productMapper.findAllProduct();
    }
    
    
}
 