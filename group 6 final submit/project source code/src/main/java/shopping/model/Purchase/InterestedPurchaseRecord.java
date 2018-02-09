package shopping.model.Purchase;

import shopping.model.Customer.Customer;
import shopping.model.ShoppingCart.ShoppingCart;

public class InterestedPurchaseRecord {
    Customer customer;
    ShoppingCart cart;

    public InterestedPurchaseRecord(Customer customer, ShoppingCart cart) {
        this.customer = customer;
        this.cart = cart;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCart getCart() {
        return cart;
    }
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}
