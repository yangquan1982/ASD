package shopping.model.Customer.Type;

import shopping.model.Customer.CustomerType;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class Standard extends CustomerType{

    public String getTypeName() {
        return "Standard";
    }

    public double calcDiscount(double totalAmount) {
        return 0;
    }
}
