package org.example.springdatajpahomework.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.ProductRequest;
import org.example.springdatajpahomework.model.dto.response.ProductResponse;
import org.example.springdatajpahomework.model.entity.Product;
import org.example.springdatajpahomework.repository.ProductRepository;
import org.example.springdatajpahomework.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> getAllProducts(Integer pageNo, Integer pageSize, String sortBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return productRepository.findAll(pageable).stream().map(Product::toResponse).toList();
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        return productRepository.save(productRequest.toEntity()).toResponse();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found!")).toResponse();
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.save(productRequest.toEntity(id)).toResponse();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
