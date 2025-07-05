package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private double totalPrice;

    public Cart() {
        this.totalPrice = 0.0;
    }

    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product cannot be null and quantity must be greater than zero");
        }

        CartItem item = new CartItem(product, quantity);
        if (!item.isAvailable()) {
            throw new IllegalArgumentException("Product is not available or expired");
        }

        items.add(item);
        totalPrice += item.getTotalPrice();
    }

    public void removeItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product cannot be null and quantity must be greater than zero");
        }

        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                if (item.getQuantity() < quantity) {
                    throw new IllegalArgumentException("Not enough quantity in cart to remove");
                }
                totalPrice -= item.getTotalPrice();
                item.reduceStock(quantity);
                totalPrice += item.getTotalPrice();
                if (item.getQuantity() == 0) {
                    items.remove(item);
                }
                return;
            }
        }

        throw new IllegalArgumentException("Product not found in cart");
    }

    public double getTotalCartPrice() {
        return totalPrice;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public void clear() {
        items.clear();
        totalPrice = 0.0;
    }
}
