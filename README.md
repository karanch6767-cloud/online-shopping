# ShopSphere — Online Shopping Website

A responsive educational e-commerce storefront made with HTML, CSS and vanilla JavaScript.

## Features
- Product catalogue with images, categories and prices
- Search products by name/category/description
- Category filtering and price/name sorting
- Add to cart, change quantities, and remove items
- Automatic subtotal, shipping estimate and total
- Cart saved in browser localStorage
- Validated demo checkout form
- Responsive desktop/mobile design
- Database design, SQL examples, test plan and contribution guide

## Tech stack
HTML5, CSS3, JavaScript ES6, browser localStorage.

## Files
- `index.html` — storefront and cart/checkout markup
- `styles.css` — responsive design
- `app.js` — product catalogue and shopping logic
- `data-model.md` — suggested relational database design and SQL
- `TESTING.md` — manual test checklist
- `CONTRIBUTING.md` — contribution guidelines

## Run locally
Clone this repository, then open `index.html` in your browser. Alternatively, run `python -m http.server 8000` in the project folder and visit `http://localhost:8000`.

## Use the store
1. Search/filter products or sort by price.
2. Add items to the cart.
3. Open the cart to change quantities or remove products.
4. Proceed to checkout and fill the demo form.

## Shopping flow
Browse → Search/filter → Add to cart → Review totals → Demo checkout → Confirmation.

## Important limitations
This is a front-end academic project, not a production commerce system. It does not authenticate users, manage inventory, create real orders, or process payments. Do not enter real personal or payment information. A production implementation requires a secure backend, server-side price validation, database transactions, authentication, HTTPS and a compliant payment provider.

## Future improvements
- Node.js/Express, Django or Spring Boot backend
- MySQL/PostgreSQL database
- Login, order history and inventory management
- Wishlist, reviews and product detail pages
- Payment integration in sandbox mode
- Automated testing and deployment

## Learning outcomes
Practise DOM manipulation, event handling, array filtering/sorting, form validation, responsive CSS and browser storage.