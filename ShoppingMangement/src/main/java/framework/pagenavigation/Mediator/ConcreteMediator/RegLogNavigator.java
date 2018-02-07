/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.FactoryMethod.page.EPageName;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.LogToRegState;
import framework.pagenavigation.State.ConcreteState.RegToLogState;
import shopping.ui.LoginPage;
import shopping.ui.Registration;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public class RegLogNavigator extends APageNavigator {
	
	private static RegLogNavigator INSTANCE;
    public static RegLogNavigator getInstance() {
        if (INSTANCE == null) {
            synchronized (Registration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RegLogNavigator();
                }
            }
        }
        return INSTANCE;
    }
	private RegLogNavigator() {
		super();
		this.fromAToBState = new RegToLogState(this);
		this.fromBToAState = new LogToRegState(this);
	}
	@Override
	public void navigate(APage startPage) {
		for (APage aPage : pages) {
			if (aPage != startPage) {
				aPage.openItself();// open the dest page
			}
		}
		currentState.navigate();// change currentState
		//close the start page
		if (startPage.getPageName().equals(EPageName.LOGINPAGE)) {
			((LoginPage) startPage).getFrame().setVisible(false);
		}
		startPage.setVisible(false);
		startPage.dispose();
		if (!startPage.getPageName().equals(EPageName.MAINPANEL)) {
			startPage = null;
		}
	}
}
