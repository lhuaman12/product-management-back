package com.lexartlabs.backendtest.dto.response;

import java.util.List;

public class GetProductByIdResponse {
    private String name;
    private String brand;
    private String model;
    private List<ProductDataResponse> data;

    public GetProductByIdResponse(String name, String brand, String model, List<ProductDataResponse> data) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.data = data;
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

    public List<ProductDataResponse> getData() {
        return data;
    }

    public void setData(List<ProductDataResponse> data) {
        this.data = data;
    }
}
