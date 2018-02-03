package framework.membership.Template;

import framework.membership.Proxy.IProxyFacade;
import framework.membership.Proxy.ProxyFacadeImp;

/**
 * Created by Duong Truong on 2/2/2018.
 */
public abstract class AbstractLogin {

    public final boolean login(){
        String username = getUsername();
        String password = getPassword();
        String passwordTarget = extractPasswordFromDataBase(username);
        return comparePassword(password,passwordTarget);

    }
    abstract String getUsername();

    abstract String getPassword();

    abstract String extractPasswordFromDataBase(String username);

    private boolean comparePassword(String password, String passwordTarget) {
        IProxyFacade proxy = ProxyFacadeImp.getInstance();
        return proxy.verifyStringByHash(password,passwordTarget);
    }
}
