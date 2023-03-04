package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.repos.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(product -> productMapper.toDto(product)).collect(Collectors.toList());
        return productDTOs;
    }
}
