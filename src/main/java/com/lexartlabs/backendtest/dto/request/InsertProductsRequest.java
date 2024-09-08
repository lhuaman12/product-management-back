package com.lexartlabs.backendtest.dto.request;

import java.util.List;

public class InsertProductsRequest {
    private String name;
    private String brand;
    private String model;
    private List<Data> data;

    public InsertProductsRequest(String name, String brand, String model, List<Data> data) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.data = data;
    }

    public InsertProductsRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
