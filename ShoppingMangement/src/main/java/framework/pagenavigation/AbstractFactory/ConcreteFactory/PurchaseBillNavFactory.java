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
		return new PurchaseBillNavigator();
	}
	@Override
	public APage createPageA() {
		return PurchaseFactory.getFactory().createPage();
	}
	@Override
	public APage createPageB() {
		return BillPageFactory.getFactory().createPage();
	}
}
