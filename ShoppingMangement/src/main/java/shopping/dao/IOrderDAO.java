package shopping.dao;

import shopping.dto.OrderDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public interface IOrderDAO {

    OrderDTO getOrder(String id) throws SQLException;

    List<OrderDTO> getOrdersByCustomer(String customerId) throws SQLException;

    boolean insertOrder(OrderDTO order) throws SQLException;
}
