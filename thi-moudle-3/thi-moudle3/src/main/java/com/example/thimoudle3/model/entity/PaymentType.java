package com.example.thimoudle3.model.entity;

public class PaymentType {
    private int id;
    private String typeName;

    public  PaymentType() {
    }

    public PaymentType(int id) {
        this.id = id;
    }

    public PaymentType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}