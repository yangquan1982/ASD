package shopping.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public class ShoppingCart {
    public ShoppingCart() {
        setLineItemList(new ArrayList<LineItem>());
    }

    private List<LineItem> lineItemList;

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }

    public boolean addCartItem(LineItem item) {

        boolean isExisted = false;
        for(LineItem _item : lineItemList) {
            if(_item.getLineItemId() == item.getLineItemId()) {
                _item.setQuantity(_item.getQuantity() + item.getQuantity());
                isExisted = true;
                break;
            }
        }

        if(!isExisted) {
            item.setSubtotal(Math.round(item.getSubtotal() * 100) / 100);
            lineItemList.add(item);
        }

        return true;
    }

    public boolean updateQuantity(LineItem item) {

        for(LineItem _item : lineItemList) {
            if(_item.getLineItemId() == item.getLineItemId()) {
                _item.setQuantity(item.getQuantity());
                return true;
            }
        }

        return false;
    }

    public boolean deleteCartItem(String lineItemId) {

        for(LineItem _item : lineItemList) {
            if(_item.getLineItemId().equals(lineItemId)) {
                lineItemList.remove(_item);
                return true;
            }
        }

        return false;
    }

    public double calculateTotalLineItems() {
        double totalValue = 0;
        for(LineItem item : lineItemList) {
            totalValue += item.getSubtotal();
        }
        return totalValue;
    }
}
