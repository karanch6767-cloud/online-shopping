# ShopSphere Online Shopping — Java Edition

A beginner-friendly console-based e-commerce project using Core Java and object-oriented programming. No external libraries or database setup are required.

## Features
- Browse a sample product catalogue
- Search products by name/category
- Add products to a cart
- Update quantities and remove cart items
- Calculate subtotal, shipping and total
- Simulated checkout and order confirmation
- Input validation and clean class-based structure

## Requirements
- JDK 17 or later
- Terminal / command prompt or an IDE such as IntelliJ IDEA, Eclipse, or VS Code with Java extensions

## Run the program
From the `java-version` directory:

```bash
javac -d out src/com/shopsphere/*.java
java -cp out com.shopsphere.Main
```

On Windows PowerShell, the same commands work when a JDK is installed and `javac` is on PATH.

## Project structure
```text
java-version/
├── README.md
├── DATABASE_DESIGN.md
├── TESTING.md
└── src/com/shopsphere/
    ├── Main.java
    ├── Product.java
    ├── CartItem.java
    ├── ShoppingCart.java
    └── Store.java
```

## Concepts demonstrated
Classes and objects, encapsulation, collections (`ArrayList`, `LinkedHashMap`), loops, conditionals, methods, exception handling, `BigDecimal` money calculations, and separation of responsibilities.

## Business rules
Shipping costs ₹99 when the subtotal is below ₹1,999. Shipping is free for orders of ₹1,999 or more. Checkout is simulated and does not collect payment or save real orders.

## Limitations and next steps
This is a console learning project. It has no real database, user login, inventory persistence, web interface, or payment integration. For a production system, use a backend API, persistent SQL database, server-side validation, secure authentication, and a payment provider's sandbox integration. See `DATABASE_DESIGN.md` for a suggested SQL model.