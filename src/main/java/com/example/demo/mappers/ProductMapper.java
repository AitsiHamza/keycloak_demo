package com.example.demo.mappers;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);
    ProductDTO toDto(Product product);
}
