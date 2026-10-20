# Manual Test Plan

| ID | Test | Expected result |
|---|---|---|
| T01 | Open index.html | Products render |
| T02 | Search watch | Minimal Watch appears |
| T03 | Search unmatched text | Empty-state message appears |
| T04 | Choose Fashion | Only Fashion items appear |
| T05 | Sort low-to-high | Prices ascend |
| T06 | Add an item | Cart count increments |
| T07 | Change quantity | Quantity and line total update |
| T08 | Remove item | Item and price disappear |
| T09 | Subtotal below ₹1,999 | ₹99 shipping appears |
| T10 | Subtotal ₹1,999+ | Shipping is free |
| T11 | Reload page after adding item | Cart persists in same browser |
| T12 | Submit empty checkout | Required fields are validated |
| T13 | Submit completed demo checkout | Confirmation appears and cart clears |
| T14 | Narrow viewport | Layout remains usable |
| T15 | Press Escape | Cart closes |

Limitations: no backend, authentication, real inventory or payment gateway. Cart is browser-local, images need internet, and checkout is simulated.