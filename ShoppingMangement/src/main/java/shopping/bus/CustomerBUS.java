package shopping.bus;

import shopping.dao.CustomerDAO;
import shopping.dto.CustomerDTO;
import shopping.dto.CustomerProfileDTO;
import shopping.model.Customer.Customer;
import shopping.util.SecurityHelper;

import java.sql.SQLException;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class CustomerBUS implements ICustomerBUS {
    private CustomerDAO customerDAO;
    private CustomerProfileDTO profileDTO;

    private CustomerBUS(){
        customerDAO = new CustomerDAO();
        profileDTO = new CustomerProfileDTO();
    }
    private static CustomerBUS customerBUS;

    public static CustomerBUS getCustomerBUS() {
        if(customerBUS == null) {
            customerBUS = new CustomerBUS();
        }

        return customerBUS;
    }

    public boolean login(String username, String password) {

        try {
            String passwordHashString = SecurityHelper.hashMD5String(password.trim());
            CustomerDTO customer = customerDAO.getCustomerByUserNameAndPassword(username.trim(), passwordHashString.toLowerCase());
            if(customer!= null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Customer register(Customer customer) {

        return null;
    }

    public boolean updateCustomer(Customer customer) {
        return false;
    }

    public Customer getCustomerByUsername(String username) {
        return null;
    }
}
