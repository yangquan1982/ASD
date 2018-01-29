package shopping.model.Customer;

/**
 * Created by Duong Truong on 1/29/2018.
 */
public class User {
    private String username;
    private String password;

    private UserProfile userProfile;
    private UserType userType;

    public User(){}

    public User(String username){
        this.username = username;
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

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
