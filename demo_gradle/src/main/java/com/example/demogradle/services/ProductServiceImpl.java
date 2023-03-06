package com.example.demogradle.services;

import com.example.demogradle.dtos.ProductDTO;
import com.example.demogradle.entities.Product;
import com.example.demogradle.mappers.ProductMapper;
import com.example.demogradle.repos.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;


    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        System.out.println(productDTO);
        Product product = productMapper.toProduct(productDTO);
        //product.setId(UUID.randomUUID().toString());
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(product -> productMapper.toDto(product)).collect(Collectors.toList());
        return productDTOs;
    }
}
