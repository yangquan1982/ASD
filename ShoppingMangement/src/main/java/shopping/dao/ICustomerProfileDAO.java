package shopping.dao;

import framework.membership.StandardUserProfile;
import shopping.dto.CustomerProfileDTO;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerProfileDAO {

    CustomerProfileDTO getCustomerProfileByUsername(String username) throws SQLException;

    boolean insertCustomerProfile(CustomerProfileDTO profileDTO) throws SQLException;

    boolean updateCustomerProfile(CustomerProfileDTO profileDTO) throws SQLException;

    boolean saveProfileToDatabase(StandardUserProfile profileEncrypted)throws SQLException;
}