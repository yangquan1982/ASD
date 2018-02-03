/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.PurchaseBillNavigator;
import shopping.ui.framework.pagefactory.BillPageFactory;
import shopping.ui.framework.pagefactory.PurchaseFactory;

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
	public APage createPageA() {
		return PurchaseFactory.getFactory().createPage();
	}
	@Override
	public APage createPageB() {
		return BillPageFactory.getFactory().createPage();
	}
}
