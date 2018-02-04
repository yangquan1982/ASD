package shopping.bus;

import framework.membership.StandardUserProfile;
import shopping.model.Customer.NewCustomerProfile;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class NewCostomerBUS {
    private SignUpBUS signup = new SignUpBUS();
    private LoginBUS loginBUS = new LoginBUS();
    private UpdateProfileBUS updateProfileBUS = new UpdateProfileBUS();

    public boolean register(String username, String password){
        return signup.SignUp(username,password);
    }

    public boolean login(String username, String password){
        return loginBUS.login(username,password);
    }

    public boolean updateProfile(StandardUserProfile profile){
        return updateProfileBUS.updateProfile(profile);
    }
}
