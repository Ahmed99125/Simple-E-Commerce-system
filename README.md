# E-Commerce System

A simple Java-based e-commerce system demonstrating core operations: product management, shopping cart, checkout flow, payment processing, and shipping integration.

## Class Diagram
![E-Commerce System Class Diagram](/assets/class_diagram.png)

## Features

- **Product Types**
    - `Product` (base class) with name, price, quantity
    - `ExpirableProduct` & `NonExpirableProduct` via `IExpirable`
    - `ShippableProduct` & `ShippableExpirableProduct` via `IShippable` (weight-based shipping)

- **Shopping Cart**
    - `Cart` and `CartItem` enforce quantity and stock validation
    - Prevent adding more than available stock
    - Empty-cart detection

- **Checkout & Payment**
    - Order validation: empty cart, expired items, out-of-stock
    - Subtotal and total calculation
    - Balance check & debit
    - Stock decrement after successful checkout
    - Generate `PaymentReceipt`

- **Shipping Integration**
    - `IShippable` interface for shipping-capable products
    - `ShippingService` processes lists of `IShippable` items

## Folder & Package Structure
```src
├── model
│ ├── Cart.java
│ ├── CartItem.java
│ ├── Customer.java
│ ├── Product.java
│ ├── ExpirableProduct.java
│ ├── IExpirable.java
│ ├── IShippable.java
│ ├── ShippableProduct.java
│ └── ShippableExpirableProduct.java
├── services
│ ├── PaymentReceipt.java
│ ├── PaymentService.java
│ └── ShippingService.java
└── Main.java
```

Classes under `model` handle core domain logic:

- Products, expiration (`IExpirable`), shipping (`IShippable`)
- Cart (`Cart`, `CartItem`) and `Customer`

Classes under `services` handle processing:

- `PaymentService` and `PaymentReceipt`
- `ShippingService`

`Main.java` demonstrates a sample run of adding products to cart and checking out.

## Testing

All test scenarios are implemented as methods in the Main class. You can uncomment the calls in Main.main(...) to run each scenario individually:

```java
// Uncomment one at a time to test:
// successScenario();
// cartEmptyScenario();
// insufficientBalanceScenario();
// outOfStockScenario();
// itemExpiredScenario();
// removeGreaterQuantityFromCartScenario();
// removingNonExistingItemFromCartScenario();
```
Each method will print either the expected success details (order summary, shipping actions, remaining balance) or the expected error message for failure cases.