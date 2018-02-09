/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.FactoryMethod.page.EPageName;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.ENavState;
import framework.pagenavigation.State.ConcreteState.MainToPListState;
import framework.pagenavigation.State.ConcreteState.PListToMainState;
import shopping.ui.Registration;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public class MainPListNavigator extends APageNavigator {
	
	private static MainPListNavigator INSTANCE;
    public static MainPListNavigator getInstance() {
        if (INSTANCE == null) {
            synchronized (Registration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MainPListNavigator();
                }
            }
        }
        return INSTANCE;
    }
	private MainPListNavigator() {
		super();
		this.fromAToBState = new MainToPListState(this);
		this.fromBToAState = new PListToMainState(this);
	}

	@Override
	public void navigate(APage startPage) {
		for (APage aPage : pages) {
			if (aPage != startPage) {
				aPage.openItself();// open the dest page
			}
		}
		//close the start page
		startPage.setVisible(false);
		startPage.dispose();
		if (currentState.getState() == ENavState.FROMBTOA) {
			startPage = null;
		}
		currentState.navigate();// change currentState
	}

}
