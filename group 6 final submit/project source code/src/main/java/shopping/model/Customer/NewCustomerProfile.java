package shopping.model.Customer;

import framework.membership.StandardUserProfile;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class NewCustomerProfile extends StandardUserProfile {
    public NewCustomerProfile(String firstName, String lastName, String username, String email, String address, String bankCardNo, String phoneNumber) {
        super(firstName, lastName, username, email, address, bankCardNo, phoneNumber);
    }

}
