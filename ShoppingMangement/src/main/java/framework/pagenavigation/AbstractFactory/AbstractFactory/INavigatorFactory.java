/**
 * 
 */
package framework.pagenavigation.AbstractFactory.AbstractFactory;

import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public interface INavigatorFactory {
	public APage createPageA(APageNavigator navigator);
	public APage createPageB(APageNavigator navigator);
	public APageNavigator createNavigator();
}
