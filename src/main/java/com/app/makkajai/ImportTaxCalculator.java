package com.app.makkajai;

public class ImportTaxCalculator implements TaxCalculator {

    private static final float IMPORT_TAX = 0.05f;
    private final TaxCalculator calculator;

    public ImportTaxCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Product getProduct() {
        return calculator.getProduct();
    }

    @Override
    public float calculate() {
        return calculator.calculate() + (getProduct().getBasePrice() * IMPORT_TAX);
    }
}
