package framework.membership.Template;

/**
 * Created by Duong Truong on 2/3/2018.
 */
public class TemplateFacadeImp implements ITemplateFacade {
    private AbstractLogin login;
    private AbstractSignUp signup;
    private AbstractUpdateProfile updateProfile;
    @Override
    public boolean SignUp(String username, String password) {
        return signup.SignUp(username,password);
    }

    @Override
    public boolean login(String username, String password) {
        return login.login(username,password);
    }

    @Override
    public boolean updateProfile() {
        return updateProfile.updateProfile();
    }
}
