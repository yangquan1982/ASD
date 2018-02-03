/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.MainPListNavigator;

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
