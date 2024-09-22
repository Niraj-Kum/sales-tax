package com.app.makkajai;

public class Product {
    private final String name;
    private final ProductType productType;
    private final boolean isImported;
    private final float basePrice;
    private final int quantity;

    public Product(String name, ProductType productType, boolean isImported, float basePrice, int quantity) {
        this.name = name;
        this.productType = productType;
        this.isImported = isImported;
        this.basePrice = basePrice;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public boolean isImported() {
        return this.isImported;
    }

    public float getBasePrice() {
        return this.basePrice;
    }

    public int getQuantity() {
        return this.quantity;
    }
}