package model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

        if (!isAvailable()) {
            if (isExpired()) {
                throw new IllegalArgumentException("Product is expired: " + product.getName());
            } else {
                throw new IllegalArgumentException("Product is not available in sufficient quantity: " + product.getName());
            }
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpired() {
        return (product instanceof ExpiredProduct) && ((ExpiredProduct) product).isExpired();
    }

    public void reduceStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (quantity < amount) {
            throw new IllegalArgumentException("Not enough quantity in cart to reduce");
        }
        quantity -= amount;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public boolean isAvailable() {
        return product.getQuantity() >= quantity && !isExpired();
    }
}
