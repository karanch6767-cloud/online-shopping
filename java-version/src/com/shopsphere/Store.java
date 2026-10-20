package com.shopsphere;

import java.util.List;
import java.util.Locale;

/** Sample catalogue and simple product search. */
public final class Store {
    private final List<Product> products = List.of(
        new Product(1, "Everyday Backpack", "Accessories", "1299.00", "A versatile bag for daily essentials."),
        new Product(2, "Classic Sneakers", "Fashion", "1899.00", "Comfortable everyday sneakers."),
        new Product(3, "Minimal Watch", "Accessories", "2499.00", "A clean, timeless wristwatch."),
        new Product(4, "Ceramic Coffee Mug", "Home", "399.00", "A simple mug for your daily brew."),
        new Product(5, "Wireless Headphones", "Electronics", "2199.00", "Enjoy music anywhere."),
        new Product(6, "Desk Lamp", "Home", "899.00", "Warm lighting for your study space."),
        new Product(7, "Travel Bottle", "Lifestyle", "549.00", "A reusable bottle for daily hydration."),
        new Product(8, "Sunglasses", "Fashion", "799.00", "Classic frames for sunny days.")
    );

    public List<Product> getProducts() { return products; }
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    public List<Product> search(String query) {
        String term = query.trim().toLowerCase(Locale.ROOT);
        if (term.isEmpty()) return products;
        return products.stream().filter(p -> p.getName().toLowerCase(Locale.ROOT).contains(term)
                || p.getCategory().toLowerCase(Locale.ROOT).contains(term)
                || p.getDescription().toLowerCase(Locale.ROOT).contains(term)).toList();
    }
}