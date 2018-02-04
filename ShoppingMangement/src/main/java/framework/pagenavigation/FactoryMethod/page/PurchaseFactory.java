/**
 * 
 */
package framework.pagenavigation.FactoryMethod.page;

import shopping.ui.Purchase;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public class PurchaseFactory implements IPageFactory {
	private static IPageFactory factory = new PurchaseFactory();
	private PurchaseFactory() {}
	public static IPageFactory getFactory() {
		return factory;
	}
	@Override
	public APage createPage() {
		return Purchase.getInstance();
	}

}
