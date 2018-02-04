/**
 * 
 */
package shopping.ui.framework.navigator.state;

import shopping.ui.framework.navigator.APageNavigator;

/**
 * @author Quan Yang
 *
 */
public class PListToMainState extends INavigatorState {

	public PListToMainState(APageNavigator navigator) {
		super(ENavState.FROMBTOA, navigator);
	}

	@Override
	public void navigate() {
		
	}

}
