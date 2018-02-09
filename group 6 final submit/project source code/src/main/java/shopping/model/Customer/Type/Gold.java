package shopping.model.Customer.Type;

import shopping.model.Customer.CustomerType;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class Gold extends CustomerType{
    public String getTypeName() {
        return "Gold";
    }

    public double calcDiscount(double totalAmount) {
        return totalAmount * 0.15;
    }
}
