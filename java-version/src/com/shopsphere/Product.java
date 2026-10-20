package com.shopsphere;

import java.math.BigDecimal;

/** A product that can be purchased from the demo store. */
public final class Product {
    private final int id;
    private final String name;
    private final String category;
    private final BigDecimal price;
    private final String description;

    public Product(int id, String name, String category, String price, String description) {
        if (id <= 0) throw new IllegalArgumentException("Product id must be positive.");
        BigDecimal parsedPrice = new BigDecimal(price);
        if (parsedPrice.signum() < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = parsedPrice;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public BigDecimal getPrice() { return price; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format("%-3d %-24s %-14s ₹%8s  %s", id, name, category, price.toPlainString(), description);
    }
}