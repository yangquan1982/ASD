/**
 * 
 */
package shopping.ui.framework.pagefactory;

import shopping.ui.BillPage;
import shopping.ui.framework.APage;

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
		return BillPage.INSTANCE;
	}

}
