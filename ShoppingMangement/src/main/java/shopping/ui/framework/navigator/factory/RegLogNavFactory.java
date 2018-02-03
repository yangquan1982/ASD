/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.RegLogNavigator;
import shopping.ui.framework.pagefactory.LoginPageFactory;
import shopping.ui.framework.pagefactory.RegPageFactory;

/**
 * @author Quan Yang
 *
 */
public class RegLogNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new RegLogNavFactory();
	private RegLogNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return new RegLogNavigator();
	}
	@Override
	public APage createPageA() {
		return RegPageFactory.getFactory().createPage();
	}
	@Override
	public APage createPageB() {
		return LoginPageFactory.getFactory().createPage();
	}
}
