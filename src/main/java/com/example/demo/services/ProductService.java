package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAll();
}
