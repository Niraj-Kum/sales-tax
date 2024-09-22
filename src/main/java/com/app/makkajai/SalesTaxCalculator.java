package com.app.makkajai;

public class SalesTaxCalculator implements TaxCalculator {
    private static final float SALES_TAX = 0.1f;
    private final TaxCalculator calculator;

    public SalesTaxCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Product getProduct() {
        return calculator.getProduct();
    }

    @Override
    public float calculate() {
        return calculator.calculate() + (getProduct().getBasePrice() * SALES_TAX);
    }
}
