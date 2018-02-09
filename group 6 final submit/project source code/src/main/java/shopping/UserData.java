package shopping;

import shopping.model.Customer.Customer;

/**
 * Created by Duong Truong on 1/31/2018.
 */
public class UserData {
    private Customer customer;

    public UserData() {
        customer = new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void clear() {
        customer = null;
    }
}
