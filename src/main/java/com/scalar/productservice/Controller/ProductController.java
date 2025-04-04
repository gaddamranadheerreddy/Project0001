package com.scalar.productservice.Controller;

import com.scalar.productservice.DTOs.FakeStoreCreateProductDto;
import com.scalar.productservice.Services.ProductService;
import com.scalar.productservice.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody
                                  FakeStoreCreateProductDto requestDto){
        Product product1 =  productService.createNewProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getImage(),
                requestDto.getPrice(),
                requestDto.getCategory()
        );

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product1,
                HttpStatusCode.valueOf(201));
        return responseEntity.getBody();
    };

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.allProducts();
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct(@RequestBody Long id){
        return productService.updateProductById(id);
    }
}
