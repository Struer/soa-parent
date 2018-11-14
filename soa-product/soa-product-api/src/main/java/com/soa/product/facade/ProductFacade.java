package com.soa.product.facade; 

import java.util.List;

import com.soa.product.domain.Product;

public interface ProductFacade {
    public List<Product> findAllProduct();
    
}
 