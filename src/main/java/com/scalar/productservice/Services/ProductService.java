package com.scalar.productservice.Services;

import com.scalar.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public Product getProductById(Long id);
}
