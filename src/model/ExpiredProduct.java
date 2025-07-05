package model;

import java.util.Date;

public class ExpiredProduct extends Product implements IExpirable {
    private Date expiryDate;

    public ExpiredProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        Date currentDate = new Date();
        return expiryDate.before(currentDate);
    }
}
