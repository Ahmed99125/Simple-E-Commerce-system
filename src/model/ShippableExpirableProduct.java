package model;

import java.util.Date;

public class ShippableExpirableProduct extends ExpiredProduct implements IShippable {
    private double weight;

    public ShippableExpirableProduct(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
