package shopping.bus;

import shopping.model.Customer.Customer;
import shopping.model.Customer.CustomerProfile;
import shopping.model.Customer.NewCustomer;
import shopping.model.Customer.NewCustomerProfile;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public interface INewCustomerBUS {

    boolean login(String username, String password);

    NewCustomer register(NewCustomer customer);

    boolean updateCustomer(NewCustomer customer);

    NewCustomer getCustomerByUsername(String username);

    NewCustomerProfile getCustomerProfileByUsername(String username);
}
