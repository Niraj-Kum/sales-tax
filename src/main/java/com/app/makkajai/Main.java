package com.app.makkajai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/*
            Input Format
            t -> number of inputs
            Example:

                Input :
                    4
                    1 imported bottle of perfume at 27.99
                    1 bottle of perfume at 18.99
                    1 packet of headache pills at 9.75
                    1 box of imported chocolates at 11.25

                Output :
                    1 imported bottle of perfume: 32.19
                    1 bottle of perfume: 20.89
                    1 packet of headache pills: 9.75
                    1 imported box of chocolates: 11.85
                    Sales Tax: 6.70
                    Total: 74.68
*/

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        Receipt receipt = new Receipt();

        IntStream.range(0, t).forEach(itr -> {
            try {
                String str = bufferedReader.readLine().trim();
                receipt.addProduct(processInputAndCreateProduct(str));
            } catch (IOException e) {
                System.out.println("Exception occurred while reading the input");
            }
        });

        bufferedReader.close();

        if(receipt.isReceiptValid()) {
            receipt.printReceipt();
        } else {
            System.out.println("Receipt cannot be generated as there are no products added to the receipt");
        }
    }

    private static Product processInputAndCreateProduct(String str) {
        String[] description = str.trim().split(" at ");
        float basePrice = Float.parseFloat(description[description.length - 1]);
        StringBuilder name = new StringBuilder();
        boolean isImported = false;
        String[] splitStr = description[0].split(" ");
        int quantity = Integer.parseInt(splitStr[0]);
        for(int i = 1; i < splitStr.length; i++) {
            if(splitStr[i].trim().startsWith("import")) {
                isImported = true;
            } else {
                name.append(splitStr[i]).append(' ');
            }
        }
        return new Product(name.toString().trim(), getProductType(name.toString()), isImported, basePrice, quantity);
    }

    private static ProductType getProductType(String x) {
        if(x.contains("chocolate")) {
            return ProductType.FOOD;
        } else if(x.contains("headache pills")) {
            return ProductType.MEDICAL_PRODUCT;
        } else if(x.contains("book")) {
            return ProductType.BOOK;
        } else {
            return ProductType.OTHERS;
        }
    }
}
