/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.LogMainNavigator;

/**
 * @author Quan Yang
 *
 */
public class LogMainNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new LogMainNavFactory();
	private LogMainNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return new LogMainNavigator();
	}
	@Override
	public APage createSrcPage() {
		return null;
	}
	@Override
	public APage createDestPage() {
		// TODO Auto-generated method stub
		return null;
	}
}
