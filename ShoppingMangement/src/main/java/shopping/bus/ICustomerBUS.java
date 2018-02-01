package shopping.bus;

import shopping.dto.CustomerDTO;
import shopping.model.Customer.Customer;
import shopping.model.Customer.CustomerProfile;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public interface ICustomerBUS {

    boolean login(String username, String password);

    Customer register(Customer customer);

    boolean updateCustomer(Customer customer);

    Customer getCustomerByUsername(String username);

    CustomerProfile getCustomerProfileByUsername(String username);
}
