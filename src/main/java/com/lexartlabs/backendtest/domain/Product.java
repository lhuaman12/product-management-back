package com.lexartlabs.backendtest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Table(name="product")
public class Product {
    @Id
    private String id;
    @Column
    private String brand;
    @Column
    private String model;
    @Transient
    private List<Data> data;

    public Product() {
    }

    public Product(String id, String brand, String model, List<Data> data) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
