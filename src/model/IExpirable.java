package model;

import java.util.Date;

public interface IExpirable {
    Date getExpiryDate();
    boolean isExpired();
}
