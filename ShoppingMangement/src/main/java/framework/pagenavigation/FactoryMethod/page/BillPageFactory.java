/**
 * 
 */
package framework.pagenavigation.FactoryMethod.page;

import shopping.ui.BillPage;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public class BillPageFactory implements IPageFactory {
	private static IPageFactory factory = new BillPageFactory();
	private BillPageFactory() {}
	public static IPageFactory getFactory() {
		return factory;
	}
	@Override
	public APage createPage() {
		return BillPage.getInstance();
	}

}
