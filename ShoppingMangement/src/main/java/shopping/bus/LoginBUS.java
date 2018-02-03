package shopping.bus;

import framework.membership.Template.AbstractLogin;
import shopping.dao.CustomerDAO;
import shopping.dao.ICustomerDAO;

import java.sql.SQLException;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class LoginBUS extends AbstractLogin{
    private ICustomerDAO customerDAO;
    @Override
    protected String extractPasswordFromDataBase(String username) {
        try {
            customerDAO = new CustomerDAO();
            customerDAO.getCustomerByUserName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
