package com.app.makkajai;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<Product> products;
    private boolean isReceiptValid;
    public Receipt() {
        this.products = new ArrayList<>();
        isReceiptValid = false;
    }

    public void printReceipt() {
        float totalTax = 0.0f;
        float totalBillAmount = 0.0f;

        for (Product product: this.products) {
            TaxCalculator calculate = new BaseTaxCalculator(product);
            if (product.getProductType() == ProductType.OTHERS)
                calculate = new SalesTaxCalculator(calculate);
            if (product.isImported())
                calculate = new ImportTaxCalculator(calculate);
            float salesTax = (float) (Math.ceil(calculate.calculate() * 20) / 20.0);
            totalBillAmount += (product.getBasePrice() + salesTax);
            totalTax += salesTax;
            if(product.isImported()) {
                System.out.printf("%d imported %s: %.2f%n", product.getQuantity(), product.getName(), (product.getBasePrice() + salesTax));
            } else {
                System.out.printf("%d %s: %.2f%n", product.getQuantity(), product.getName(), (product.getBasePrice() + salesTax));
            }
        }
        System.out.printf("Sales Tax: %.2f%n", totalTax);
        System.out.printf("Total: %.2f%n", totalBillAmount);
    }

    public void addProduct(Product prod) {
        this.isReceiptValid = true;
        this.products.add(prod);
    }

    public boolean isReceiptValid() {
        return this.isReceiptValid;
    }
}
