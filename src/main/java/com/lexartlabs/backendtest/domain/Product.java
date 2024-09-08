package com.lexartlabs.backendtest.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String brand;
    @Column
    private String model;
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    private List<Data> data;

    public Product() {
    }

    public Product(Long id, String name, String brand, String model, List<Data> data) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
