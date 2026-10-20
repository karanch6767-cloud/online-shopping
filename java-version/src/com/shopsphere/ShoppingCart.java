package com.shopsphere;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/** Cart logic kept separate from console input/output. */
public final class ShoppingCart {
    private static final BigDecimal FREE_SHIPPING_THRESHOLD = new BigDecimal("1999.00");
    private static final BigDecimal SHIPPING_FEE = new BigDecimal("99.00");
    private final Map<Integer, CartItem> items = new LinkedHashMap<>();

    public void add(Product product, int quantity) {
        if (product == null) throw new IllegalArgumentException("Product not found.");
        if (quantity < 1 || quantity > 99) throw new IllegalArgumentException("Quantity must be between 1 and 99.");
        CartItem existing = items.get(product.getId());
        int updated = quantity + (existing == null ? 0 : existing.getQuantity());
        if (updated > 99) throw new IllegalArgumentException("Maximum quantity per product is 99.");
        if (existing == null) items.put(product.getId(), new CartItem(product, quantity));
        else existing.setQuantity(updated);
    }

    public boolean changeQuantity(int productId, int quantity) {
        if (!items.containsKey(productId)) return false;
        if (quantity <= 0) items.remove(productId);
        else items.get(productId).setQuantity(quantity);
        return true;
    }

    public boolean remove(int productId) { return items.remove(productId) != null; }
    public boolean isEmpty() { return items.isEmpty(); }
    public Collection<CartItem> getItems() { return items.values(); }
    public void clear() { items.clear(); }

    public BigDecimal getSubtotal() {
        return items.values().stream().map(CartItem::getLineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public BigDecimal getShipping() {
        BigDecimal subtotal = getSubtotal();
        return subtotal.signum() == 0 || subtotal.compareTo(FREE_SHIPPING_THRESHOLD) >= 0
                ? BigDecimal.ZERO : SHIPPING_FEE;
    }
    public BigDecimal getTotal() { return getSubtotal().add(getShipping()); }
}