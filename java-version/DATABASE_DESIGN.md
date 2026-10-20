# Database Design for ShopSphere

The Java edition currently uses in-memory sample data. For a database-backed extension, MySQL tables could include:

- `customers`: customer ID, name, unique email, password hash, created timestamp
- `categories`: category ID and unique category name
- `products`: product ID, category ID, name, description, decimal price, stock quantity, active flag
- `orders`: order ID, customer ID, status, subtotal, shipping fee, total, created timestamp
- `order_items`: order ID, product ID, product-name snapshot, unit price snapshot, quantity
- `cart_items`: customer ID, product ID, quantity
- `reviews`: customer ID, product ID, rating from 1 to 5, comment

## Example SQL
```sql
CREATE TABLE products (
  product_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  category_id BIGINT,
  name VARCHAR(180) NOT NULL,
  description TEXT,
  price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
  stock_quantity INT NOT NULL DEFAULT 0 CHECK (stock_quantity >= 0),
  active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE orders (
  order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  customer_id BIGINT NOT NULL,
  status VARCHAR(20) NOT NULL DEFAULT 'pending',
  subtotal DECIMAL(10,2) NOT NULL,
  shipping_fee DECIMAL(10,2) NOT NULL DEFAULT 0,
  total DECIMAL(10,2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
  order_item_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  order_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  product_name_snapshot VARCHAR(180) NOT NULL,
  unit_price DECIMAL(10,2) NOT NULL,
  quantity INT NOT NULL CHECK (quantity > 0)
);
```

## Security and integrity
Use prepared statements with JDBC. Calculate order totals on the server, use a database transaction for order and stock updates, hash passwords with a suitable password-hashing algorithm, and never store card numbers or CVVs. Integrate payment through a trusted provider in sandbox mode.