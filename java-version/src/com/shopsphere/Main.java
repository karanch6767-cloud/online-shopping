package com.shopsphere;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/** Console entry point for the ShopSphere Java demo. */
public final class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Store STORE = new Store();
    private static final ShoppingCart CART = new ShoppingCart();

    private Main() { }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       SHOPSPHERE ONLINE SHOPPING");
        System.out.println("========================================");
        boolean running = true;
        while (running) {
            System.out.println("\n1. View products  2. Search products  3. Add to cart");
            System.out.println("4. View cart      5. Change quantity  6. Remove item");
            System.out.println("7. Checkout       0. Exit");
            int choice = readInt("Choose an option: ");
            try {
                switch (choice) {
                    case 1 -> showProducts(STORE.getProducts());
                    case 2 -> searchProducts();
                    case 3 -> addToCart();
                    case 4 -> showCart();
                    case 5 -> changeQuantity();
                    case 6 -> removeItem();
                    case 7 -> checkout();
                    case 0 -> running = false;
                    default -> System.out.println("Please choose a listed option.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Cannot complete action: " + ex.getMessage());
            }
        }
        System.out.println("Thank you for visiting ShopSphere!");
    }

    private static void showProducts(List<Product> products) {
        if (products.isEmpty()) { System.out.println("No matching products found."); return; }
        System.out.printf("%-3s %-24s %-14s %-10s %s%n", "ID", "PRODUCT", "CATEGORY", "PRICE", "DETAILS");
        products.forEach(System.out::println);
    }

    private static void searchProducts() {
        System.out.print("Search by name, category, or keyword: ");
        showProducts(STORE.search(INPUT.nextLine()));
    }

    private static void addToCart() {
        showProducts(STORE.getProducts());
        int id = readInt("Enter product ID: ");
        Product product = STORE.findById(id);
        if (product == null) { System.out.println("Product ID not found."); return; }
        int quantity = readInt("Quantity (1-99): ");
        CART.add(product, quantity);
        System.out.println("Added to cart.");
    }

    private static void showCart() {
        if (CART.isEmpty()) { System.out.println("Your cart is empty."); return; }
        System.out.println("\nYOUR CART");
        for (CartItem item : CART.getItems()) {
            System.out.printf("%s × %d = %s%n", item.getProduct().getName(), item.getQuantity(), money(item.getLineTotal()));
        }
        printTotals();
    }

    private static void changeQuantity() {
        showCart();
        if (CART.isEmpty()) return;
        int id = readInt("Product ID to change: ");
        int quantity = readInt("New quantity (0 removes item): ");
        if (quantity > 99) throw new IllegalArgumentException("Quantity must not exceed 99.");
        System.out.println(CART.changeQuantity(id, quantity) ? "Cart updated." : "That product is not in your cart.");
    }

    private static void removeItem() {
        showCart();
        if (CART.isEmpty()) return;
        int id = readInt("Product ID to remove: ");
        System.out.println(CART.remove(id) ? "Item removed." : "That product is not in your cart.");
    }

    private static void printTotals() {
        System.out.println("Subtotal: " + money(CART.getSubtotal()));
        System.out.println("Shipping: " + (CART.getShipping().signum() == 0 ? "Free" : money(CART.getShipping())));
        System.out.println("Total:    " + money(CART.getTotal()));
    }

    private static void checkout() {
        if (CART.isEmpty()) { System.out.println("Add a product before checkout."); return; }
        showCart();
        System.out.print("Proceed with DEMO checkout? (yes/no): ");
        if (!INPUT.nextLine().trim().equalsIgnoreCase("yes")) { System.out.println("Checkout cancelled."); return; }
        String orderId = "DEMO-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        BigDecimal total = CART.getTotal();
        CART.clear();
        System.out.println("Demo order confirmed: " + orderId);
        System.out.println("Order total: " + money(total));
        System.out.println("No payment was collected; this is only a simulation.");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = INPUT.nextLine().trim();
            try { return Integer.parseInt(raw); }
            catch (NumberFormatException ex) { System.out.println("Enter a whole number."); }
        }
    }

    private static String money(BigDecimal amount) {
        return "₹" + amount.setScale(2, java.math.RoundingMode.HALF_UP).toPlainString();
    }
}