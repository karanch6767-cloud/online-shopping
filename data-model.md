# Online Shopping Database Design

Suggested relational schema for a future full-stack version. The current storefront uses sample JavaScript data and browser storage.

## Entities and relationships
- Customer has many Addresses and Orders.
- Category has many Products.
- Order has many OrderItems; each item references a Product and snapshots its price/name.
- Customer has a Cart containing CartItems.
- Customer can review Products.
- Orders can be linked to Payment provider references.

## Example MySQL schema
```sql
CREATE TABLE customers (customer_id BIGINT PRIMARY KEY AUTO_INCREMENT, full_name VARCHAR(120) NOT NULL, email VARCHAR(254) NOT NULL UNIQUE, password_hash VARCHAR(255) NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE categories (category_id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(80) NOT NULL UNIQUE);
CREATE TABLE products (product_id BIGINT PRIMARY KEY AUTO_INCREMENT, category_id BIGINT, name VARCHAR(180) NOT NULL, description TEXT, price DECIMAL(10,2) NOT NULL CHECK(price>=0), stock_quantity INT NOT NULL DEFAULT 0 CHECK(stock_quantity>=0), image_url VARCHAR(1000), active BOOLEAN DEFAULT TRUE, FOREIGN KEY(category_id) REFERENCES categories(category_id));
CREATE TABLE orders (order_id BIGINT PRIMARY KEY AUTO_INCREMENT, customer_id BIGINT NOT NULL, status VARCHAR(20) NOT NULL DEFAULT 'pending', subtotal DECIMAL(10,2) NOT NULL, shipping_fee DECIMAL(10,2) NOT NULL DEFAULT 0, total DECIMAL(10,2) NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY(customer_id) REFERENCES customers(customer_id));
CREATE TABLE order_items (order_item_id BIGINT PRIMARY KEY AUTO_INCREMENT, order_id BIGINT NOT NULL, product_id BIGINT NOT NULL, product_name_snapshot VARCHAR(180) NOT NULL, unit_price DECIMAL(10,2) NOT NULL, quantity INT NOT NULL CHECK(quantity>0), FOREIGN KEY(order_id) REFERENCES orders(order_id) ON DELETE CASCADE, FOREIGN KEY(product_id) REFERENCES products(product_id));
CREATE TABLE cart_items (customer_id BIGINT NOT NULL, product_id BIGINT NOT NULL, quantity INT NOT NULL CHECK(quantity>0), PRIMARY KEY(customer_id,product_id), FOREIGN KEY(customer_id) REFERENCES customers(customer_id), FOREIGN KEY(product_id) REFERENCES products(product_id));
CREATE TABLE reviews (review_id BIGINT PRIMARY KEY AUTO_INCREMENT, customer_id BIGINT NOT NULL, product_id BIGINT NOT NULL, rating TINYINT NOT NULL CHECK(rating BETWEEN 1 AND 5), comment TEXT, UNIQUE(customer_id,product_id), FOREIGN KEY(customer_id) REFERENCES customers(customer_id), FOREIGN KEY(product_id) REFERENCES products(product_id));
```

## Example queries
```sql
SELECT p.name,p.price,c.name AS category FROM products p LEFT JOIN categories c ON c.category_id=p.category_id WHERE p.active=TRUE ORDER BY p.name;
SELECT product_id,product_name_snapshot,SUM(quantity) AS units_sold FROM order_items GROUP BY product_id,product_name_snapshot ORDER BY units_sold DESC;
```

## Production notes
Recalculate prices and totals on the server. Use transactions for order creation and inventory. Store password hashes, never plaintext passwords. Use a payment provider's hosted checkout/tokenization and never store card numbers or CVVs. Add indexes to frequently filtered columns.