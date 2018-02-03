/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.MainPurchaseNavigator;
import shopping.ui.framework.pagefactory.MainPanelFactory;
import shopping.ui.framework.pagefactory.PurchaseFactory;

/**
 * @author Quan Yang
 *
 */
public class MainPurchaseNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new MainPurchaseNavFactory();
	private MainPurchaseNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return new MainPurchaseNavigator();
	}
	@Override
	public APage createPageA() {
		return MainPanelFactory.getFactory().createPage();
	}
	@Override
	public APage createPageB() {
		return PurchaseFactory.getFactory().createPage();
	}
}
