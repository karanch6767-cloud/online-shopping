package com.shopsphere;

import java.math.BigDecimal;

/** A product and its selected quantity in the cart. */
public final class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (product == null) throw new IllegalArgumentException("Product is required.");
        if (quantity < 1 || quantity > 99) throw new IllegalArgumentException("Quantity must be between 1 and 99.");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        if (quantity < 1 || quantity > 99) throw new IllegalArgumentException("Quantity must be between 1 and 99.");
        this.quantity = quantity;
    }
    public BigDecimal getLineTotal() { return product.getPrice().multiply(BigDecimal.valueOf(quantity)); }
}