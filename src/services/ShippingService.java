package services;

import model.CartItem;
import model.IShippable;

import java.util.List;

public class ShippingService {
    private double shippingRate;

    public ShippingService(double shippingRate) {
        this.shippingRate = shippingRate;
    }

    public double calculateShippingCost(IShippable item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        return item.getWeight() * shippingRate;
    }

    public void shipItems(List<CartItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Items list cannot be null or empty");
        }

        double totalShippingCost = 0;
        for (CartItem item : items) {
            if (!(item.getProduct() instanceof IShippable)) {
                throw new IllegalArgumentException("All items must implement IShippable interface");
            }
            IShippable shippableItem = (IShippable) item.getProduct();
            System.out.println("Shipping " + item.getQuantity() + "x " + shippableItem.getName() +
                    " (" + shippableItem.getWeight() + "g each)");
        }
    }
}
