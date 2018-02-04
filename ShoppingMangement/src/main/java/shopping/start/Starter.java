/**
 * 
 */
package shopping.start;

import framework.pagenavigation.AbstractFactory.ConcreteFactory.RegLogNavFactory;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		APageNavigator regLogNavigator = RegLogNavFactory.getFactory().createNavigator();
		APage regPage = RegLogNavFactory.getFactory().createPageA(regLogNavigator);
		APage loginPage = RegLogNavFactory.getFactory().createPageB(regLogNavigator);
		regLogNavigator.addPage(regPage);
		regLogNavigator.addPage(loginPage);
	}
}
