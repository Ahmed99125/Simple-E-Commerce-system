package services;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private ShippingService shippingService;

    public PaymentService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        double subtotal = 0;
        double shippingCost = 0;
        List<CartItem> purchasedItems = new ArrayList<>();
        List<CartItem> shippedItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (!item.isAvailable()) {
                if (item.isExpired()) {
                    throw new IllegalArgumentException("Product " + product.getName() + " is expired");
                } else {
                    throw new IllegalArgumentException("Product " + product.getName() + " is not available in sufficient quantity");
                }
            }
            product.decreaseQuantity(item.getQuantity());
            subtotal += item.getTotalPrice();
            purchasedItems.add(item);

            if (product instanceof IShippable) {
                shippedItems.add(item);
                shippingCost += shippingService.calculateShippingCost((IShippable) product) * item.getQuantity(); // Example shipping cost calculation
            }
        }

        customer.debitBalance(subtotal + shippingCost);
        PaymentReceipt receipt = new PaymentReceipt(customer.getName(), subtotal, shippingCost, purchasedItems, shippedItems);
        customer.addReceipt(receipt);
        receipt.printReceipt();
        cart.clear();
    }
}