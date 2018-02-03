/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.APage;
import shopping.ui.framework.navigator.APageNavigator;
import shopping.ui.framework.navigator.RegLogNavigator;

/**
 * @author Quan Yang
 *
 */
public class RegLogNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new RegLogNavFactory();
	private RegLogNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return new RegLogNavigator();
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
