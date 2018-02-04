package shopping.ui;

import framework.membership.StandardUserProfile;
import shopping.bus.NewCostomerBUS;
import shopping.model.Customer.NewCustomerProfile;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class UpdateProfilePage {
    private NewCostomerBUS newCostomerBUS = new NewCostomerBUS();

    public static StandardUserProfile updateProflie(String username){
        StandardUserProfile profile =  new StandardUserProfile.Builder()
                .setUsername(username)
                .setAddress("120 North West, Fairefield, IA")
                .setBankCardNo("123456789")
                .setFirstName("John")
                .setLastName("Snow")
                .setEmail("john@email.com")
                .setPhoneNumber("7642142123")
                .build();
        return  profile;
    }
}
