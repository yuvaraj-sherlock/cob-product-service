package com.cob.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private double rating; // out of 5
    private String category; // e.g., "MOBILE", "LAPTOP", "ACCESSORY"
}
