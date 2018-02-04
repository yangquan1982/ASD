/**
 * 
 */
package shopping.ui.framework.navigator.state;

import shopping.ui.framework.navigator.RegLogNavigator;

/**
 * @author Quan Yang
 *
 */
public class RegToLogState extends INavigatorState {
	
	public RegToLogState(RegLogNavigator navigator) {
		super(ENavState.FROMATOB, navigator);
	}

	@Override
	public void navigate() {
		navigator.setCurrentState(navigator.getFromBToAState());
	}

}
