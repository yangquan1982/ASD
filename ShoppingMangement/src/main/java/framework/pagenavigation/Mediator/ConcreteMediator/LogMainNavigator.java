/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.ENavState;
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
		//close the start page
		if (currentState.getState() == ENavState.FROMATOB) {
			((LoginPage) startPage).getFrame().setVisible(false);
		}
		startPage.setVisible(false);
		startPage.dispose();
		if (currentState.getState() == ENavState.FROMATOB) {
			startPage = null;
		}
		currentState.navigate();// change currentState
	}
}
