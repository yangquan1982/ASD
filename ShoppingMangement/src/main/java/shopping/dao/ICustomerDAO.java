package shopping.dao;

import shopping.dto.CustomerDTO;

import java.sql.SQLException;

public interface ICustomerDAO {

    CustomerDTO getCustomerByUserNameAndPassword(String username, String password) throws SQLException;

    boolean insertUser(CustomerDTO user) throws SQLException;

    boolean updateUser(CustomerDTO user) throws SQLException;
}