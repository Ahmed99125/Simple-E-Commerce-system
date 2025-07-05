package services;

import model.CartItem;
import model.IShippable;

import java.util.Date;
import java.util.List;

public class PaymentReceipt {
    private String customerName;
    private double subtotal;
    private double shippingCost;
    private Date paymentDate;
    private List<CartItem> purchasedItems;
    private List<CartItem> shippedItems;

    public PaymentReceipt(String customerName, double subtotal, double shippingCost,
                          List<CartItem> purchasedItems, List<CartItem> shippedItems) {
        this.customerName = customerName;
        this.subtotal = subtotal;
        this.shippingCost = shippingCost;
        this.purchasedItems = purchasedItems;
        this.shippedItems = shippedItems;
        this.paymentDate = new Date();
    }

    public void printReceipt() {
        if (shippedItems != null && !shippedItems.isEmpty()) {
            System.out.println("** Shipment notice **");
            double totalWeight = 0;
            for (CartItem item : shippedItems) {
                double itemWeight = ((IShippable) item.getProduct()).getWeight() * item.getQuantity();
                System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "\t" +
                        itemWeight + "g");
                totalWeight += itemWeight;
            }
            System.out.println("Total package weight: " + totalWeight / 1000.0 + "kg\n");
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : purchasedItems) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "\t" +
                    item.getTotalPrice());
        }
        System.out.println("-------------------------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingCost);
        System.out.println("Amount: " + (subtotal + shippingCost));
        System.out.println("-------------------------------------");
        System.out.println("Payment date: " + paymentDate);
        System.out.println("Customer: " + customerName);
    }
}
