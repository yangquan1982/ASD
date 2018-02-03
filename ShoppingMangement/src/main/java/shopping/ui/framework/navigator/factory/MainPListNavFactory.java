/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.MainPListNavigator;
import shopping.ui.framework.pagefactory.MainPanelFactory;
import shopping.ui.framework.pagefactory.PListPageFactory;

/**
 * @author Quan Yang
 *
 */
public class MainPListNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new MainPListNavFactory();
	private MainPListNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return new MainPListNavigator();
	}
	@Override
	public APage createPageA() {
		return MainPanelFactory.getFactory().createPage();
	}
	@Override
	public APage createPageB() {
		return PListPageFactory.getFactory().createPage();
	}
}
