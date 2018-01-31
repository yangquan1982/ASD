package shopping.bus;

import shopping.dao.CustomerDAO;
import shopping.dao.CustomerProfileDAO;
import shopping.dao.ICustomerDAO;
import shopping.dao.ICustomerProfileDAO;
import shopping.dto.CustomerDTO;
import shopping.dto.CustomerProfileDTO;
import shopping.model.Customer.Customer;
import shopping.model.Customer.CustomerProfile;
import shopping.util.SecurityHelper;

import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class CustomerBUS implements ICustomerBUS {
    private ICustomerDAO customerDAO;
    private ICustomerProfileDAO profileDAO;

    private CustomerBUS(){
        customerDAO = new CustomerDAO();
        profileDAO = new CustomerProfileDAO();
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
        try {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setUsername(customer.getUsername());
            customerDTO.setPassword(SecurityHelper.hashMD5String(customer.getPassword()).toLowerCase());
            boolean success = customerDAO.insertUser(customerDTO);
            if (success){
                CustomerProfileDTO profileDTO = new CustomerProfileDTO();
                CustomerProfile profile = customer.getCustomerProfile();

                UUID customerId = UUID.randomUUID();
                profileDTO.setId(customerId.toString());
                profileDTO.setUsername(customer.getUsername());
                profileDTO.setEmail(profile.getEmail());
                profileDTO.setAddress(profile.getAddress());
                profileDTO.setFullName(profile.getFullName());
                profileDTO.setBankCardNo(profile.getBankCardNo());
                profileDTO.setShippingAddress(profile.getShippingAddress());

                profileDAO.insertCustomerProfile(profileDTO);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public boolean updateCustomer(Customer customer) {
        try {
            CustomerProfileDTO profileDTO = new CustomerProfileDTO();
            CustomerProfile profile = customer.getCustomerProfile();

            profileDTO.setUsername(profile.getUsername());
            profileDTO.setAddress(profile.getAddress());
            profileDTO.setFullName(profile.getFullName());
            profileDTO.setEmail(profile.getEmail());
            profileDTO.setBankCardNo(profile.getBankCardNo());
            profileDTO.setShippingAddress(profile.getShippingAddress());
            boolean success = profileDAO.updateCustomerProfile(profileDTO);

            if(success){
                if(!customer.getPassword().equals("")){
                    //update password
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setUsername(customer.getUsername());
                    customerDTO.setPassword(SecurityHelper.hashMD5String(customer.getPassword()).toLowerCase());
                    return customerDAO.updateUser(customerDTO);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        try {
            CustomerDTO customerDTO = customerDAO.getCustomerByUserName(username);
            Customer customer = new Customer();
            customer.setUsername(customerDTO.getUsername());
            customer.setPassword(customerDTO.getPassword());
//            CustomerProfileDTO profile = profileDAO.getCustomerProfileByUsername(username);
//            if(profile != null) {
//                return new CustomerProfile(profile.getId(), profile.getUsername(),profile.getFullName(),profile.getAddress(),
//                        profile.getEmail(),profile.getBankCardNo(),profile.getShippingAddress());
//            }
            return customer;
        } catch (SQLException ex) {
        }

        return null;
    }

    public CustomerProfile getCustomerProfileByUsername(String username) {
        try {
            CustomerProfileDTO profile = profileDAO.getCustomerProfileByUsername(username);
            if(profile != null) {
                return new CustomerProfile(profile.getId(), profile.getUsername(),profile.getFullName(),profile.getAddress(),
                        profile.getEmail(),profile.getBankCardNo(),profile.getShippingAddress());
            }
        } catch (SQLException ex) {
        }

        return null;
    }
}
