/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.FactoryMethod.page.EPageName;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.LogToMainState;
import framework.pagenavigation.State.ConcreteState.MainToLogState;
import shopping.ui.LoginPage;
import shopping.ui.Registration;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public class LogMainNavigator extends APageNavigator {
	
	private static LogMainNavigator INSTANCE;
    public static LogMainNavigator getInstance() {
        if (INSTANCE == null) {
            synchronized (Registration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LogMainNavigator();
                }
            }
        }
        return INSTANCE;
    }
	private LogMainNavigator() {
		super();
		this.fromAToBState = new LogToMainState(this);
		this.fromBToAState = new MainToLogState(this);
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
