package shopping.bus;

import shopping.model.ShoppingCart.LineItem;
import shopping.model.ShoppingCart.Order;

import java.util.List;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public interface IOrderBUS {
    boolean placeOrder(Order order);

    List<Order> getOrdersByCustomer(String customerId);
}
