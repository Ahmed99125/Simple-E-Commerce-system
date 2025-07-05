package model;

import services.PaymentReceipt;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private double balance;
    private Cart cart;
    private List<PaymentReceipt> receipts;

    public Customer(String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.cart = new Cart();
        this.receipts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void debitBalance(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public void addReceipt(PaymentReceipt receipt) {
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt cannot be null");
        }
        receipts.add(receipt);
    }
}
