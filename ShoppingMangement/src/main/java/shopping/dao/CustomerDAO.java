package shopping.dao;

import shopping.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class CustomerDAO implements ICustomerDAO {
    private IDbConnection dbConnection;

    public CustomerDTO getCustomerByUserNameAndPassword(String username, String password) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM User WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractUCustomerFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    private CustomerDTO extractUCustomerFromResultSet(ResultSet rs) throws SQLException {
        CustomerDTO customer = new CustomerDTO();
        customer.setUsername(rs.getString("username"));
        return customer;
    }
    public boolean insertUser(CustomerDTO user) throws SQLException {
        return false;
    }

    public boolean updateUser(CustomerDTO user) throws SQLException {
        return false;
    }
}
