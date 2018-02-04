/**
 * 
 */
package framework.pagenavigation.AbstractFactory.ConcreteFactory;

import framework.pagenavigation.AbstractFactory.AbstractFactory.INavigatorFactory;
import framework.pagenavigation.FactoryMethod.page.MainPanelFactory;
import framework.pagenavigation.FactoryMethod.page.PurchaseFactory;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.Mediator.ConcreteMediator.MainPurchaseNavigator;
import shopping.ui.abstractproduct.APage;

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
		return MainPurchaseNavigator.getInstance();
	}
	@Override
	public APage createPageA(APageNavigator navigator) {
		return MainPanelFactory.getFactory().createPage(navigator);
	}
	@Override
	public APage createPageB(APageNavigator navigator) {
		return PurchaseFactory.getFactory().createPage(navigator);
	}
}
