package com.scalar.productservice.Services;

import com.scalar.productservice.DTOs.FakeStoreProductDto;
import com.scalar.productservice.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
//        FakeStoreProductDto responseDto = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/" + id,
//                FakeStoreProductDto.class
//        );
//        return responseDto.toProduct();

        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate
                .getForEntity("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class
                );

        if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(404)) {
            //show some error to FE
        }
        else if(responseEntity.getStatusCode() == HttpStatusCode.valueOf(500)){
            //Tell FE that BE is not working currently
        }

        return responseEntity.getBody().toProduct();
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

    @Override
    public List<Product> allProducts() {
        FakeStoreProductDto[] response1 =  restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto productDto : response1) {
            products.add(productDto.toProduct());
        }

        return products;
    }
}
