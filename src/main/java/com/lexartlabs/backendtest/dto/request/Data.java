package com.lexartlabs.backendtest.dto.request;

public class Data {
    private Integer price;
    private String color;

    public Data(Integer price, String color) {
        this.price = price;
        this.color = color;
    }

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
}
