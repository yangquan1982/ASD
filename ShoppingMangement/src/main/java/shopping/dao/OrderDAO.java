package shopping.dao;

import shopping.dto.OrderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public class OrderDAO implements IOrderDAO {

    private DbConnection dbConnection;

    public OrderDAO() {
        dbConnection = new DbConnection();
    }

    private OrderDTO extractOrderFromResultSet(ResultSet rs) throws SQLException {
        OrderDTO order = new OrderDTO();
        order.setId( rs.getString("id"));
        order.setCustomerId( rs.getString("customerId"));
        order.setDateCreated(rs.getString("dateCreated"));
        order.setDateShipped(rs.getString("dateShipped"));
        order.setStatus(rs.getString("status"));
        order.setBankCardNo(rs.getString("bankCardNo"));
        order.setShippingAddress(rs.getString("shippingAddress"));
        order.setShippingCost(rs.getDouble("shippingCost"));
        order.setDiscountTotal(rs.getDouble("discountTotal"));
        return order;
    }

    @Override
    public OrderDTO getOrder(String id) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `Order` WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractOrderFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    @Override
    public List<OrderDTO> getOrdersByCustomer(String customerId) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `Order` WHERE customerId=?");
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            List<OrderDTO> orders = new ArrayList<OrderDTO>();
            while(rs.next())
            {
                OrderDTO order = extractOrderFromResultSet(rs);
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertOrder(OrderDTO order) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `Order` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, order.getId());
            ps.setString(2, order.getCustomerId());
            ps.setString(3, order.getDateCreated());
            ps.setString(4, order.getDateShipped());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getBankCardNo());
            ps.setString(7, order.getShippingAddress());
            ps.setDouble(8, order.getShippingCost());
            ps.setDouble(9, order.getDiscountTotal());
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
