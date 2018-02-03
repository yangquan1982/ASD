package shopping.bus;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class NewCostomerBUS {
    private SignUpBUS signup = new SignUpBUS();

    public boolean register(String username, String password){
        return signup.SignUp(username,password);
    }
}
