/**
 * 
 */
package framework.pagenavigation.AbstractFactory.ConcreteFactory;

import framework.pagenavigation.AbstractFactory.AbstractFactory.INavigatorFactory;
import framework.pagenavigation.FactoryMethod.page.LoginPageFactory;
import framework.pagenavigation.FactoryMethod.page.MainPanelFactory;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.Mediator.ConcreteMediator.LogMainNavigator;
import shopping.ui.abstractproduct.APage;

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
		return LogMainNavigator.getInstance();
	}
	@Override
	public APage createPageA(APageNavigator navigator) {
		return LoginPageFactory.getFactory().createPage(navigator);
	}
	@Override
	public APage createPageB(APageNavigator navigator) {
		return MainPanelFactory.getFactory().createPage(navigator);
	}
}
