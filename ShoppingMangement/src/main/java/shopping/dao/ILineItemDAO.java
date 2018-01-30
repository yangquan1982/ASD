package shopping.dao;

import shopping.dto.LineItemDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public interface ILineItemDAO {
    boolean insertLineItem(LineItemDTO lineItem) throws SQLException;

    List<LineItemDTO> getLineItemsByOrder(String orderId) throws SQLException;
}
