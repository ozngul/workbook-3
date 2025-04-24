package com.pluralsight;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchInventory {
    public static void main(String[] args) {
        // Load inventory from resources folder
        ArrayList<Product> inventory = loadInventoryFromResources("inventory.csv");

        // Sort products by name
        Collections.sort(inventory, Comparator.comparing(Product::getName));

        // Display all products
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    // Method to load product list from a CSV file located in the resources folder
    public static ArrayList<Product> loadInventoryFromResources(String filename) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            // Load the file as an InputStream from the classpath
            InputStream is = SearchInventory.class.getClassLoader().getResourceAsStream(filename);
            if (is == null) {
                System.out.println("File not found: " + filename);
                return products;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            // Read each line, split by "|" and create Product objects
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    products.add(new Product(id, name, price));
                }
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return products;
    }
}
