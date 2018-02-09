package shopping.bus;

import shopping.model.ShoppingCart.LineItem;

import java.util.List;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public interface ILineItemBUS {
    List<LineItem> getLineItemsByOrder(String orderId);
}
