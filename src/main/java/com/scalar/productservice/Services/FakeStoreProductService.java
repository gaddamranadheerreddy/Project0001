package com.scalar.productservice.Services;

import com.scalar.productservice.DTOs.FakeStoreProductDto;
import com.scalar.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
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

    @Override
    public Product createNewProduct(String title, String description, String imageUrl, Double price, String category) {

        FakeStoreProductDto requestDto = new FakeStoreProductDto();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setImage(imageUrl);
        requestDto.setPrice(String.valueOf(price));
        requestDto.setCategory(category);

        FakeStoreProductDto responseDto = restTemplate.
                postForObject("https://fakestoreapi.com/products",
                requestDto,
                FakeStoreProductDto.class
        );

        return responseDto.toProduct();
    }
}
