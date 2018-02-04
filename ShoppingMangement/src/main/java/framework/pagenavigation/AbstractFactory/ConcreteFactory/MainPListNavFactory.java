/**
 * 
 */
package framework.pagenavigation.AbstractFactory.ConcreteFactory;

import framework.pagenavigation.AbstractFactory.AbstractFactory.INavigatorFactory;
import framework.pagenavigation.FactoryMethod.page.MainPanelFactory;
import framework.pagenavigation.FactoryMethod.page.PListPageFactory;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.Mediator.ConcreteMediator.MainPListNavigator;
import shopping.ui.abstractproduct.APage;

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
		return MainPListNavigator.getInstance();
	}
	@Override
	public APage createPageA(APageNavigator navigator) {
		return MainPanelFactory.getFactory().createPage(navigator);
	}
	@Override
	public APage createPageB(APageNavigator navigator) {
		return PListPageFactory.getFactory().createPage(navigator);
	}
}
