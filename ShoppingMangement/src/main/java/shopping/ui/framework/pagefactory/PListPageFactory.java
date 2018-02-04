/**
 * 
 */
package shopping.ui.framework.pagefactory;

import shopping.ui.ProductListPage;
import shopping.ui.framework.APage;

/**
 * @author Quan Yang
 *
 */
public class PListPageFactory implements IPageFactory {
	private static IPageFactory factory = new PListPageFactory();
	private PListPageFactory() {}
	public static IPageFactory getFactory() {
		return factory;
	}
	@Override
	public APage createPage() {
		return ProductListPage.getInstance();
	}

}
