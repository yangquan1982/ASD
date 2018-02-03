package framework.membership.Template;

import framework.membership.Proxy.*;
import framework.membership.Proxy.Validate.StringType;


/**
 * Created by Duong Truong on 2/2/2018.
 */
public abstract class AbstractSignUp {
    IProxyFacade proxy = ProxyFacadeImp.getInstance();
    public final boolean SignUp(){
        String username = getUsername();
        String password = getPassword();
        boolean isUserExist = checkUserExist(username);
        boolean isInvalidatePassword = validatePassword(password);
        if(isUserExist || isInvalidatePassword) return false;
        else{
            String hashPassword = hashPassword(password);
            saveUser(username,hashPassword);
            return true;
        }
    }

    abstract void saveUser(String username, String hashPassword);

    private String hashPassword(String password) {
        return proxy.getHashString(password);
    }


    private boolean validatePassword(String password) {
       return proxy.validateString(StringType.Password,password);
    }
    abstract boolean checkUserExist(String username);

    abstract String getPassword();

    abstract String getUsername();
}
