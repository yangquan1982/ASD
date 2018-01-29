package shopping.model.Customer;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public abstract class CustomerType {
    public abstract String getTypeName();
    public abstract double calcDiscount(double totalAmount);
}
