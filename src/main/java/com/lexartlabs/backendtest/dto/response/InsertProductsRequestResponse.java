package com.lexartlabs.backendtest.dto.response;

public class InsertProductsRequestResponse {
    private String status;
    private String message;
    private Integer insertedCount;

    public InsertProductsRequestResponse(String status, String message, Integer insertedCount) {
        this.status = status;
        this.message = message;
        this.insertedCount = insertedCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getInsertedCount() {
        return insertedCount;
    }

    public void setInsertedCount(Integer insertedCount) {
        this.insertedCount = insertedCount;
    }
}
