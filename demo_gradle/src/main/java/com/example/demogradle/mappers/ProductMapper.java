package com.example.demogradle.mappers;

import com.example.demogradle.dtos.ProductDTO;
import com.example.demogradle.entities.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);
    ProductDTO toDto(Product product);
}
