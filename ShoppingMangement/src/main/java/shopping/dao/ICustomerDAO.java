package shopping.dao;

import shopping.dto.CustomerDTO;

import java.sql.SQLException;

public interface ICustomerDAO {
    public String getPasswordByUserName(String username) throws SQLException;
    CustomerDTO getCustomerByUserNameAndPassword(String username, String password) throws SQLException;

    CustomerDTO getCustomerByUserName(String username) throws SQLException;

    boolean insertUser(CustomerDTO user) throws SQLException;

    boolean updateUser(CustomerDTO user) throws SQLException;
}