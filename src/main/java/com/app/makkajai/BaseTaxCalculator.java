package com.app.makkajai;

public class BaseTaxCalculator implements TaxCalculator {

    private final Product product;

    public BaseTaxCalculator(Product product) {
        this.product = product;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public float calculate() {
        return 0.0f;
    }
}
