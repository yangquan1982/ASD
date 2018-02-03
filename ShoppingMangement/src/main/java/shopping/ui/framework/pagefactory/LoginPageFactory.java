/**
 * 
 */
package shopping.ui.framework.pagefactory;

import shopping.ui.LoginPage;
import shopping.ui.framework.APage;

/**
 * @author Quan Yang
 *
 */
public class LoginPageFactory implements IPageFactory {
	private static IPageFactory factory = new LoginPageFactory();
	private LoginPageFactory() {}
	public static IPageFactory getFactory() {
		return factory;
	}
	@Override
	public APage createPage() {
		return LoginPage.INSTANCE;
	}

}
