package com.example.demomaven.services;

import com.example.demomaven.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAll();
}
