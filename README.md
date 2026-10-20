# ShopSphere — Online Shopping Project

This repository contains two educational implementations of an online shopping system:

- **Java console application:** Core Java, object-oriented design, product search, shopping cart, quantity management, shipping calculations, demo checkout, database design and testing guide. Start here: [`java-version/README.md`](java-version/README.md).
- **Web storefront:** HTML, CSS and JavaScript responsive storefront with product catalogue, search/filtering, cart and simulated checkout. Start here: [`index.html`](index.html).

## Java version (recommended if your assignment requires Java)
Requires JDK 17 or later. From the `java-version` directory, run:

```bash
javac -d out src/com/shopsphere/*.java
java -cp out com.shopsphere.Main
```

Java source code is in `java-version/src/com/shopsphere/`. Read [`java-version/DATABASE_DESIGN.md`](java-version/DATABASE_DESIGN.md) for a suggested SQL model and [`java-version/TESTING.md`](java-version/TESTING.md) for a manual test checklist.

## Web version
Open `index.html` in a browser, or run `python -m http.server 8000` from the repository root and visit `http://localhost:8000`.

## Important note
Both versions are learning demos. Checkout does not take real payments, and neither version provides production authentication, persistent orders, or real inventory. Never enter sensitive personal or payment details.
