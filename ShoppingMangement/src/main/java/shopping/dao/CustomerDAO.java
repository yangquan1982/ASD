package shopping.dao;

import shopping.dto.CustomerDTO;
import shopping.dto.CustomerProfileDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class CustomerDAO implements ICustomerDAO {
    private IDbConnection dbConnection;

    public CustomerDAO() {
        dbConnection = new DbConnection();
    }

    @Override
    public String getPasswordByUserName(String username) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Customer WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractPasswordFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    private String extractPasswordFromResultSet(ResultSet rs) throws SQLException {
        return rs.getString("password");
    }

    public CustomerDTO getCustomerByUserNameAndPassword(String username, String password) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Customer WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractCustomerFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    @Override
    public CustomerDTO getCustomerByUserName(String username) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Customer WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractCustomerFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    private CustomerDTO extractCustomerFromResultSet(ResultSet rs) throws SQLException {
        CustomerDTO customer = new CustomerDTO();
        customer.setUsername(rs.getString("username"));
        return customer;
    }

    public boolean insertUser(CustomerDTO user) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Customer VALUES (?, ?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return false;
    }

    public boolean updateUser(CustomerDTO user) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE Customer SET password=? WHERE username=?");
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsername());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return false;
    }


}
