import model.*;
import services.PaymentService;
import services.ShippingService;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Uncomment the scenarios you want to test
        // Each scenario simulates a different situation in the e-commerce system

//        successSenario();
//        cartEmptySenario();
//        insufficientBalanceSenario();
//        outOfStockSenario();
//        itemExpiredSenario();
//        removeGreatedQuantityFromCartSenario();
//        removingNonExistingItemFromCartSenario();
    }

    static void successSenario() {
        Product product1 = new Product("Laptop", 1000.0, 10);
        Product product2 = new Product("Smartphone", 500.0, 20);
        Product cheese = new ExpiredProduct("cheese", 800.0, 5, new Date(2026, 1, 1));
        Product book = new ShippableProduct("book", 20.0, 50, 300);
        Product food = new ShippableExpirableProduct("food", 10.0, 10, new Date(2032, 1, 1), 200);

        Customer customer = new Customer("John Doe", "a.s@g.com", 2000.0);

        ShippingService shippingService = new ShippingService(0.2);
        PaymentService paymentService = new PaymentService(shippingService);

        Cart cart = customer.getCart();

        cart.addItem(food, 2);
        cart.addItem(cheese, 2);

        paymentService.checkout(customer, customer.getCart());
    }

    static void cartEmptySenario() {
        Product product1 = new Product("Laptop", 1000.0, 10);
        Product product2 = new Product("Smartphone", 500.0, 20);
        Product cheese = new ExpiredProduct("cheese", 800.0, 5, new Date(2026, 1, 1));
        Product book = new ShippableProduct("book", 20.0, 50, 300);
        Product food = new ShippableExpirableProduct("food", 10.0, 10, new Date(2032, 1, 1), 200);

        Customer customer = new Customer("John Doe", "a.s@g.com", 2000.0);

        ShippingService shippingService = new ShippingService(0.2);
        PaymentService paymentService = new PaymentService(shippingService);

        Cart cart = customer.getCart();

        paymentService.checkout(customer, customer.getCart());
    }

    static void insufficientBalanceSenario() {
        Product product1 = new Product("Laptop", 1000.0, 10);
        Product product2 = new Product("Smartphone", 500.0, 20);
        Product cheese = new ExpiredProduct("cheese", 800.0, 5, new Date(2026, 1, 1));
        Product book = new ShippableProduct("book", 20.0, 50, 300);
        Product food = new ShippableExpirableProduct("food", 10.0, 10, new Date(2032, 1, 1), 200);

        Customer customer = new Customer("John Doe", "a.s@g.com", 0.0);

        ShippingService shippingService = new ShippingService(0.2);
        PaymentService paymentService = new PaymentService(shippingService);

        Cart cart = customer.getCart();

        cart.addItem(food, 2);
        cart.addItem(cheese, 2);

        paymentService.checkout(customer, customer.getCart());
    }

    static void outOfStockSenario() {
        Product product1 = new Product("Laptop", 1000.0, 10);
        Product product2 = new Product("Smartphone", 500.0, 20);
        Product cheese = new ExpiredProduct("cheese", 800.0, 5, new Date(2026, 1, 1));
        Product book = new ShippableProduct("book", 20.0, 50, 300);
        Product food = new ShippableExpirableProduct("food", 10.0, 10, new Date(2032, 1, 1), 200);

        Customer customer = new Customer("John Doe", "a.s@g.com", 2000.0);

        ShippingService shippingService = new ShippingService(0.2);
        PaymentService paymentService = new PaymentService(shippingService);

        Cart cart = customer.getCart();

        cart.addItem(food, 200); // Attempting to add more than available stock
        cart.addItem(cheese, 2);

        paymentService.checkout(customer, customer.getCart());
    }

    static void itemExpiredSenario() {
        Product product1 = new Product("Laptop", 1000.0, 10);
        Product product2 = new Product("Smartphone", 500.0, 20);
        Product cheese = new ExpiredProduct("cheese", 800.0, 5, new Date(2026, 1, 1));
        Product book = new ShippableProduct("book", 20.0, 50, 300);
        Product food = new ShippableExpirableProduct("food", 10.0, 10, new Date(), 200);

        Customer customer = new Customer("John Doe", "a.s@g.com", 2000.0);

        ShippingService shippingService = new ShippingService(0.2);
        PaymentService paymentService = new PaymentService(shippingService);

        Cart cart = customer.getCart();

        cart.addItem(food, 2); // Attempting to add an expired item
        cart.addItem(cheese, 2);

        paymentService.checkout(customer, customer.getCart());
    }

    static void removeGreatedQuantityFromCartSenario() {
        Product product1 = new Product("Laptop", 1000.0, 10);
        Product product2 = new Product("Smartphone", 500.0, 20);
        Product cheese = new ExpiredProduct("cheese", 800.0, 5, new Date(2026, 1, 1));
        Product book = new ShippableProduct("book", 20.0, 50, 300);
        Product food = new ShippableExpirableProduct("food", 10.0, 10, new Date(2026, 1, 1), 200);

        Customer customer = new Customer("John Doe", "a.s@g.com", 2000.0);

        ShippingService shippingService = new ShippingService(0.2);
        PaymentService paymentService = new PaymentService(shippingService);

        Cart cart = customer.getCart();

        cart.addItem(food, 2);
        cart.addItem(cheese, 2);

        cart.removeItem(food, 5); // Attempting to remove more than available in the cart

        paymentService.checkout(customer, customer.getCart());
    }

    static void removingNonExistingItemFromCartSenario() {
        Product product1 = new Product("Laptop", 1000.0, 10);
        Product product2 = new Product("Smartphone", 500.0, 20);
        Product cheese = new ExpiredProduct("cheese", 800.0, 5, new Date(2026, 1, 1));
        Product book = new ShippableProduct("book", 20.0, 50, 300);
        Product food = new ShippableExpirableProduct("food", 10.0, 10, new Date(2026, 1, 1), 200);

        Customer customer = new Customer("John Doe", "a.s@g.com", 2000.0);

        ShippingService shippingService = new ShippingService(0.2);
        PaymentService paymentService = new PaymentService(shippingService);

        Cart cart = customer.getCart();

        cart.addItem(food, 2);
        cart.addItem(cheese, 2);

        cart.removeItem(book, 5); // Attempting to remove an item that is not in the cart

        paymentService.checkout(customer, customer.getCart());
    }
}