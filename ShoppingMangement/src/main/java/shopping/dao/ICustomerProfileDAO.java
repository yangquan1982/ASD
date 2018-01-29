package shopping.dao;

import shopping.dto.CustomerProfileDTO;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerProfileDAO {

    List<CustomerProfileDTO> getUserSettingsByUsername(String username) throws SQLException;

    boolean insertUserSetting(CustomerProfileDTO userProfile) throws SQLException;

    boolean updateUserSetting(CustomerProfileDTO userProfile) throws SQLException;
}