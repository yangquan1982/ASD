/**
 * 
 */
package shopping.ui.framework.pagefactory;

import shopping.ui.Registration;
import shopping.ui.framework.APage;

/**
 * @author Quan Yang
 *
 */
public class RegPageFactory implements IPageFactory {
	private APage regPage = null;
	private static IPageFactory factory = new RegPageFactory();
	private RegPageFactory() {}
	public static IPageFactory getFactory() {
		return factory;
	}
	@Override
	public APage createPage() {
		return Registration.INSTANCE;
	}

}
