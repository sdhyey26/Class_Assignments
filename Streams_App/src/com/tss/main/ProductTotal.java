package com.tss.main;

import java.util.Arrays;
import java.util.List;
import com.tss.model.*;

public class ProductTotal {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Pen", 10.0, 2),
            new Product("Notebook", 50.0, 3),
            new Product("Pencil", 5.0, 5)
        );
        
        double totalBill = products.stream()
            .map(p -> p.price * p.quantity)
            .reduce(0.0, Double::sum);

        System.out.println("Total Bill: ₹" + totalBill);
    }
}
