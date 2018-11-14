package com.soa.product.persistence; 

import java.util.List;

import com.soa.product.domain.Product;


public interface ProductMapper {
    public List<Product> findAllProduct();
}
 