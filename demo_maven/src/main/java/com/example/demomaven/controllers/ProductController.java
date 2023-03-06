package com.example.demomaven.controllers;

import com.example.demomaven.dtos.ProductDTO;
import com.example.demomaven.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.ACCEPTED);
    }
    @PostMapping("/create")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.saveProduct(productDTO),HttpStatus.ACCEPTED);
    }
}
