package shopping.bus;

import framework.membership.Template.AbstractSignUp;
import shopping.dao.CustomerDAO;
import shopping.dao.CustomerProfileDAO;
import shopping.dao.ICustomerDAO;
import shopping.dao.ICustomerProfileDAO;
import shopping.dto.CustomerDTO;

import java.sql.SQLException;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class NewCustomerBUS extends AbstractSignUp {
    private ICustomerDAO customerDAO = new CustomerDAO();
    private ICustomerProfileDAO profileDAO = new CustomerProfileDAO();

    //SignUpTemplate
    @Override
    protected void saveUser(String username, String hashPassword) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setUsername(username);
        customerDTO.setPassword(hashPassword);
        try {
            customerDAO.insertUser(customerDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SignUpTemplate
    @Override
    protected boolean checkUserExist(String username) {
        try {
            if(customerDAO.getCustomerByUserName(username) != null){
             return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
