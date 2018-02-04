/**
 * 
 */
package framework.pagenavigation.FactoryMethod.page;

import shopping.ui.LoginPage;
import shopping.ui.abstractproduct.APage;

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
		return LoginPage.getInstance();
	}

}
