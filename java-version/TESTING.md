# Java Console App Test Checklist

Compile with `javac -d out src/com/shopsphere/*.java`, then run `java -cp out com.shopsphere.Main`.

1. View products: eight sample products should be listed.
2. Search `watch`: Minimal Watch should appear.
3. Search a missing term: no matching products message appears.
4. Add product ID 1 with quantity 2: cart contains two backpacks.
5. Add the same product again: quantity increases.
6. Enter quantity 0 in change-quantity: item is removed.
7. Remove a valid ID: item disappears.
8. Empty cart checkout: checkout is prevented.
9. Subtotal below ₹1,999: shipping is ₹99.
10. Subtotal at or above ₹1,999: shipping is free.
11. Enter letters at a numeric prompt: program asks again instead of crashing.
12. Confirm checkout with `yes`: demo order ID is shown and cart clears.
13. Confirm checkout with `no`: cart remains unchanged.
14. Exit with `0`: program ends cleanly.

This checklist is manual; no automated test framework is included.