package shopping.bus;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class NewCostomerBUS {
    private SignUpBUS signup = new SignUpBUS();
    private LoginBUS loginBUS = new LoginBUS();

    public boolean register(String username, String password){
        return signup.SignUp(username,password);
    }

    public boolean login(String username, String password){
        return loginBUS.login(username,password);
    }
}
