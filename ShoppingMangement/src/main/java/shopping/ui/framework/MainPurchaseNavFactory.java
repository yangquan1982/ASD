/**
 * 
 */
package shopping.ui.framework;

/**
 * @author Quan Yang
 *
 */
public class MainPurchaseNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new MainPurchaseNavFactory();
	private MainPurchaseNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return new MainPurchaseNavigator();
	}
}
