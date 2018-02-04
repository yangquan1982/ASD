/**
 * 
 */
package framework.pagenavigation.AbstractFactory.ConcreteFactory;

import framework.pagenavigation.AbstractFactory.AbstractFactory.INavigatorFactory;
import framework.pagenavigation.FactoryMethod.page.LoginPageFactory;
import framework.pagenavigation.FactoryMethod.page.RegPageFactory;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.Mediator.ConcreteMediator.RegLogNavigator;
import shopping.ui.abstractproduct.APage;

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
		return RegLogNavigator.getInstance();
	}
	@Override
	public APage createPageA(APageNavigator navigator) {
		return RegPageFactory.getFactory().createPage(navigator);
	}
	@Override
	public APage createPageB(APageNavigator navigator) {
		return LoginPageFactory.getFactory().createPage(navigator);
	}
}
