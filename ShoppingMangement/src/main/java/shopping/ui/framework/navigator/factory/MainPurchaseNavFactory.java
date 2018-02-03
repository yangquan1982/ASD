/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.MainPurchaseNavigator;

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
	public APage createSrcPage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public APage createDestPage() {
		// TODO Auto-generated method stub
		return null;
	}
}
