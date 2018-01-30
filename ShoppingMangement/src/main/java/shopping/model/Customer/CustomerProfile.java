package shopping.model.Customer;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class CustomerProfile {
    private Customer customer;
    private String id;
    private String username;
    private String fullName;

    private String address;
    private String email;
    private String bankCardNo;
    private String shippingAddress;

    public CustomerProfile(String id, String username, String fullName, String address, String email, String bankCardNo, String shippingAddress) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.bankCardNo = bankCardNo;
        this.shippingAddress = shippingAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
