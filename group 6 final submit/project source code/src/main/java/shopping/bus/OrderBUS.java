package shopping.bus;

import shopping.dao.*;
import shopping.dto.LineItemDTO;
import shopping.dto.OrderDTO;
import shopping.model.ShoppingCart.LineItem;
import shopping.model.ShoppingCart.Order;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public class OrderBUS implements IOrderBUS {

    private OrderDAO orderDAO;
    private LineItemDAO lineItemDAO;

    private OrderBUS() {
        orderDAO = new OrderDAO();
        lineItemDAO = new LineItemDAO();
    }

    private static OrderBUS orderBUS;

    public static OrderBUS getOrderBUS() {
        if(orderBUS == null) {
            orderBUS = new OrderBUS();
        }

        return orderBUS;
    }

    @Override
    public boolean placeOrder(Order order) {

        try {
            UUID orderId = UUID.randomUUID();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            boolean retValue = orderDAO.insertOrder(
                    new OrderDTO(
                            orderId.toString(),
                            order.getCustomer().getUsername(),
                            dateFormat.format(order.getDateCreated()),
                            dateFormat.format(order.getDateShipped()),
                            order.getStatus(),
                            order.getBankCardNo(),
                            order.getShippingAddress(),
                            order.getShippingCost(),
                            order.getDiscountTotal()));
            if(retValue) {
                // reset order Id
                order.setOrderId(orderId.toString());

                for(LineItem item : order.getLineItemList()) {
                    LineItemDTO LineItemDTO = new LineItemDTO();
                    UUID lineItemId = UUID.randomUUID();
                    LineItemDTO.setId(lineItemId.toString());
                    LineItemDTO.setOrderId(orderId.toString());
                    LineItemDTO.setProductId(item.getLineItemId());
                    LineItemDTO.setProductName(item.getProductName());
                    LineItemDTO.setQuantity(item.getQuantity());
                    LineItemDTO.setUnitCost(item.getUnitCost());
                    LineItemDTO.setSubtotal(item.getSubtotal());
                    retValue = lineItemDAO.insertLineItem(LineItemDTO);
                    if(retValue) {
                        // reset line item Id
                        item.setLineItemId(lineItemId.toString());
                    }
                }

                return true;
            }
        } catch (SQLException ex) {
        }

        return false;
    }

    @Override
    public List<Order> getOrdersByCustomer(String username) {
        try {
            List<OrderDTO> OrderDTOList = orderDAO.getOrdersByCustomer(username);
            if(OrderDTOList != null) {
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                List<Order> orders = new ArrayList<Order>();
                for(OrderDTO OrderDTO : OrderDTOList) {
                    Date dateCreated = df.parse(OrderDTO.getDateCreated());
                    Date dateShipped = df.parse(OrderDTO.getDateShipped());
                    Order order = new Order(OrderDTO.getId(),
                            dateCreated,
                            dateShipped,
                            OrderDTO.getStatus(),
                            OrderDTO.getBankCardNo(),
                            OrderDTO.getShippingAddress(),
                            OrderDTO.getShippingCost(),
                            OrderDTO.getDiscountTotal());
                    List<LineItem> lineItems = LineItemBUS.getLineItemBUS()
                            .getLineItemsByOrder(OrderDTO.getId());
                    order.setLineItemList(lineItems);
                    orders.add(order);
                }
                return orders;
            }
        } catch (ParseException ex) {
        } catch (SQLException ex) {
        }

        return null;
    }
}
