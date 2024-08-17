package org.example.springdatajpahomework.service;

import org.example.springdatajpahomework.model.dto.request.ProductRequest;
import org.example.springdatajpahomework.model.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    void deleteProduct(Long id);
}
