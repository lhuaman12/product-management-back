package com.lexartlabs.backendtest.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product_data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer price;
    @Column
    private String color;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public Data(Integer price, String color,Product product) {
        this.price = price;
        this.color = color;
        this.product = product;
    }
    public Data() {}

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
