package com.scalar.productservice.DTOs;

import com.scalar.productservice.models.Category;
import com.scalar.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice( Double.valueOf(price));
        product.setImageUrl(image);

        Category cat = new Category();
        cat.setName(category);
        product.setCategory(cat);
        return product;
    }
}
