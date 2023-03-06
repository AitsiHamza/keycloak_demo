package com.example.demomaven.mappers;

import com.example.demomaven.dtos.ProductDTO;
import com.example.demomaven.entities.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);
    ProductDTO toDto(Product product);
}
