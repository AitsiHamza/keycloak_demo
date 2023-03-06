package com.example.demogradle.mappers;

import com.example.demogradle.dtos.ProductDTO;
import com.example.demogradle.entities.Product;
import org.springframework.beans.BeanUtils;

public class ProductMapper2 {
    public Product toProduct(ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        return product;
    }
    public ProductDTO toDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        return productDTO;
    }
}
