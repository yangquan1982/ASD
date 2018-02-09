package shopping.model.Customer;

import shopping.model.ShoppingCart.Order;
import shopping.model.ShoppingCart.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class Customer {
    private String username;
    private String password;

    private CustomerProfile customerProfile;
    private CustomerType customerType;

    private boolean loginStatus;
    private List<Order> orderList;

    private ShoppingCart shoppingCart;

    public Customer(){}

    public Customer(String username){
        this.username = username;
        setOrderList(new ArrayList<Order>());
        setShoppingCart(new ShoppingCart());
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
