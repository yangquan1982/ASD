/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.PurchaseBillNavigator;

/**
 * @author Quan Yang
 *
 */
public class PurchaseBillNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new PurchaseBillNavFactory();
	private PurchaseBillNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return new PurchaseBillNavigator();
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
