package com.cob.product.mapper;

import com.cob.product.entity.ProductEntity;
import com.cob.product.model.ProductDto;

public class ProductMapper {

    public static ProductEntity toEntity(ProductDto productDto){
        return ProductEntity.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .rating(productDto.getRating())
                .category(productDto.getCategory())
                .build();
    }

    public static ProductDto toDto(ProductEntity productEntity){
        return ProductDto.builder()
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .rating(productEntity.getRating())
                .category(productEntity.getCategory())
                .build();
    }
}
