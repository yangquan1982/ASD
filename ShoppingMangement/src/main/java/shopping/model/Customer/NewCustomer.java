package shopping.model.Customer;

import framework.membership.StandardMember;
import shopping.model.ShoppingCart.Order;
import shopping.model.ShoppingCart.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class NewCustomer extends StandardMember{
    private NewCustomerProfile profile;


    private boolean loginStatus;
    private List<Order> orderList;

    private ShoppingCart shoppingCart;

    private CustomerType customerType;

    public NewCustomer(String username){
        super();
        this.setUsername(username);
        setOrderList(new ArrayList<Order>());
        setShoppingCart(new ShoppingCart());
    }


    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public void setProfile(NewCustomerProfile profile) {
        this.profile = profile;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
