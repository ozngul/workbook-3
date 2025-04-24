package com.pluralsight;

import java.util.ArrayList;

public class SearchInventory {

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("Product Inventory:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(4567, "10' 2x4 (grade B)", 9.99));
        products.add(new Product(1234, "Hammer", 19.49));
        products.add(new Product(2345, "Box of nails", 9.29));
        products.add(new Product(3456, "Screwdriver", 5.99));
        products.add(new Product(5678, "Measuring Tape", 12.49));
        return products;
    }
}