package com.scalar.productservice.Services;

import com.scalar.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public Product getProductById(Long id);
    public Product createNewProduct(String title, String description,
                                 String imageUrl, Double price, String category);
    public List<Product> allProducts();
}
