/**
 * 
 */
package framework.pagenavigation.AbstractFactory.ConcreteFactory;

import framework.pagenavigation.AbstractFactory.AbstractFactory.INavigatorFactory;
import framework.pagenavigation.FactoryMethod.page.BillPageFactory;
import framework.pagenavigation.FactoryMethod.page.PurchaseFactory;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.Mediator.ConcreteMediator.PurchaseBillNavigator;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public class PurchaseBillNavFactory implements INavigatorFactory {
	private static INavigatorFactory factory = new PurchaseBillNavFactory();
	private PurchaseBillNavFactory() {}
	public static INavigatorFactory getFactory() {
		return factory;
	}
	@Override
	public APageNavigator createNavigator() {
		return PurchaseBillNavigator.getInstance();
	}
	@Override
	public APage createPageA(APageNavigator navigator) {
		return PurchaseFactory.getFactory().createPage(navigator);
	}
	@Override
	public APage createPageB(APageNavigator navigator) {
		return BillPageFactory.getFactory().createPage(navigator);
	}
}
