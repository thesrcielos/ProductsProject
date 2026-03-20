package com.project.products.service;

import com.project.products.dto.ProductRequest;
import com.project.products.dto.ProductResponse;
import com.project.products.exception.ProductException;
import com.project.products.model.Product;
import com.project.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getProducts(){
        return productRepository.findAll()
                .stream()
                .map(this::productToResponse)
                .toList();
    }

    public ProductResponse createOrUpdateProduct(ProductRequest request){
        if (request.price().compareTo(new BigDecimal("0")) < 0 || request.stock() <= 0){
            throw new ProductException("Price and Stock must be gretaer than 0", 400);
        }
        Optional<Product> productOptional = productRepository.findByNameIgnoreCase(request.name());
        if (productOptional.isPresent()){
            Product savedProduct = productOptional.get();
            savedProduct.setName(request.name());
            savedProduct.setPrice(request.price());
            savedProduct.setStock(request.stock());
            productRepository.save(savedProduct);

            return productToResponse(savedProduct);
        }

        Product product = new Product(null, request.name(), request.price(), request.stock());
        productRepository.save(product);

        return productToResponse(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public ProductResponse productToResponse(Product product){
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getStock());
    }
}
