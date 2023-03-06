package com.example.demogradle.services;

import com.example.demogradle.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAll();
}
