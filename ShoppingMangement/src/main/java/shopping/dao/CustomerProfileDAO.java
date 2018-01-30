package shopping.dao;

import shopping.dto.CustomerProfileDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class CustomerProfileDAO implements ICustomerProfileDAO{
    private IDbConnection dbConnection;

    public CustomerProfileDAO(){
        dbConnection = new DbConnection();
    }

    private CustomerProfileDTO extractUserSettingFromResultSet(ResultSet rs) throws SQLException {
        CustomerProfileDTO userSetting = new CustomerProfileDTO();
        userSetting.setId( rs.getString("id"));

        return userSetting;
    }

    public CustomerProfileDTO getUserSettingsByUsername(String username) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM UserSetting WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            CustomerProfileDTO userSettings = new CustomerProfileDTO();

            return userSettings;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    public boolean insertUserSetting(CustomerProfileDTO userProfile) throws SQLException {
        return false;
    }

    public boolean updateUserSetting(CustomerProfileDTO userProfile) throws SQLException {
        return false;
    }
}