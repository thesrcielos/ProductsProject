package com.project.products.controller;

import com.project.products.dto.ProductRequest;
import com.project.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOrUpdateProduct(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(productService.createOrUpdateProduct(productRequest), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
