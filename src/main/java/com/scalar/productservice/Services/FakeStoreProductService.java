package com.scalar.productservice.Services;

import com.scalar.productservice.DTOs.FakeStoreProductDto;
import com.scalar.productservice.models.Product;
import org.springframework.web.client.RestTemplate;

public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto responseDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );
        return responseDto.toProduct();
    }
}
