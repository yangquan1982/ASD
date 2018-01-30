package shopping.bus;

import shopping.dao.LineItemDAO;
import shopping.dto.LineItemDTO;
import shopping.model.ShoppingCart.LineItem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public class LineItemBUS implements ILineItemBUS {

    private LineItemDAO lineItemDAO;

    public LineItemBUS() {
        lineItemDAO = new LineItemDAO();
    }

    private static LineItemBUS lineItemBUS;

    public static LineItemBUS getLineItemBUS() {
        if(lineItemBUS == null) {
            lineItemBUS = new LineItemBUS();
        }

        return lineItemBUS;
    }

    @Override
    public List<LineItem> getLineItemsByOrder(String orderId) {
        try {
            List<LineItemDTO> LineItemDTOList = lineItemDAO.getLineItemsByOrder(orderId);
            if(LineItemDTOList != null) {
                List<LineItem> lineItems = new ArrayList<LineItem>();
                for(LineItemDTO LineItemDTO : LineItemDTOList) {
                    lineItems.add(new LineItem(
                            LineItemDTO.getId(),
                            LineItemDTO.getProductName(),
                            LineItemDTO.getQuantity(),
                            LineItemDTO.getUnitCost(),
                            LineItemDTO.getSubtotal()));
                }
                return lineItems;
            }
        } catch (SQLException ex) {
        }

        return null;
    }
}
