/**
 * 
 */
package shopping.ui.framework.pagefactory;

import shopping.ui.Purchase;
import shopping.ui.framework.APage;

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
