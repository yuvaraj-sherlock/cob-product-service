package com.cob.product.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "COB_PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Double rating;
    private LocalDate availableDate;
}
