package shopping.bus;

import shopping.model.Customer.Customer;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public interface ICustomerBUS {

    boolean login(String username, String password);

    Customer register(Customer customer);

    boolean updateCustomer(Customer customer);

    Customer getCustomerByUsername(String username);
}
