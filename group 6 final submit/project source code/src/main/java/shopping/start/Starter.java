/**
 * 
 */
package shopping.start;

import framework.pagenavigation.AbstractFactory.ConcreteFactory.RegLogNavFactory;
import framework.pagenavigation.FactoryMethod.page.EPageName;
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
		APage regPage = RegLogNavFactory.getFactory().createPageA(EPageName.REGPAGE, regLogNavigator);
		APage loginPage = RegLogNavFactory.getFactory().createPageB(EPageName.LOGINPAGE, regLogNavigator);
		regLogNavigator.setPageAB(regPage, loginPage);
		regPage.open();
	}
}
