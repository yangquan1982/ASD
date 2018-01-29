package shopping.dao;

import shopping.dto.CustomerDTO;

import java.sql.SQLException;

public interface ICustomerDAO {

    CustomerDTO getCustomerByUsername(String username) throws SQLException;

    boolean insertCustomer(CustomerDTO customer) throws SQLException;

    boolean updateCustomer(CustomerDTO customer) throws SQLException;
}