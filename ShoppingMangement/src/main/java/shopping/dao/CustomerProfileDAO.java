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

    private CustomerProfileDTO extractProfileFromResultSet(ResultSet rs) throws SQLException {
        CustomerProfileDTO profileDTO = new CustomerProfileDTO();
        profileDTO.setId( rs.getString("id"));
        profileDTO.setUsername(rs.getString("username"));
        profileDTO.setFullName(rs.getString("customerName"));
        profileDTO.setAddress(rs.getString("address"));
        profileDTO.setEmail(rs.getString("email"));
        profileDTO.setBankCardNo(rs.getString("bankCardNo"));
        profileDTO.setShippingAddress(rs.getString("shippingAddress"));
        return profileDTO;
    }

    public CustomerProfileDTO getCustomerProfileByUsername(String username) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM CustomerProfile WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            CustomerProfileDTO profileDTO = extractProfileFromResultSet(rs);

            return profileDTO;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    public boolean insertCustomerProfile(CustomerProfileDTO profileDTO) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO CustomerProfile VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, profileDTO.getId());
            ps.setString(2, profileDTO.getUsername());
            ps.setString(3, profileDTO.getFullName());
            ps.setString(4, profileDTO.getAddress());
            ps.setString(5, profileDTO.getEmail());
            ps.setString(6, profileDTO.getBankCardNo());
            ps.setString(7, profileDTO.getShippingAddress());
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

    public boolean updateCustomerProfile(CustomerProfileDTO profileDTO) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE Customer SET customerName=?, address=?, email=?, bankCardNo=?, shippingAddress=? WHERE username=?");
            ps.setString(1, profileDTO.getFullName());
            ps.setString(2, profileDTO.getAddress());
            ps.setString(3, profileDTO.getEmail());
            ps.setString(4, profileDTO.getBankCardNo());
            ps.setString(5, profileDTO.getShippingAddress());
            ps.setString(6, profileDTO.getUsername());
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
