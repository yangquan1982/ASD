/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.LogMainNavigator;
import shopping.ui.framework.pagefactory.LoginPageFactory;
import shopping.ui.framework.pagefactory.MainPanelFactory;

/**
 * @author Quan Yang
 *
 */
public class LogMainNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new LogMainNavFactory();
	private LogMainNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return new LogMainNavigator();
	}
	@Override
	public APage createPageA() {
		return LoginPageFactory.getFactory().createPage();
	}
	@Override
	public APage createPageB() {
		return MainPanelFactory.getFactory().createPage();
	}
}
