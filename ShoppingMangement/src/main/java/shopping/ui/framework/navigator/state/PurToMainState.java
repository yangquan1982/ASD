/**
 * 
 */
package shopping.ui.framework.navigator.state;

import shopping.ui.framework.navigator.APageNavigator;

/**
 * @author Quan Yang
 *
 */
public class PurToMainState extends INavigatorState {

	public PurToMainState(APageNavigator navigator) {
		super(ENavState.FROMBTOA, navigator);
	}

	@Override
	public void navigate() {
		
	}

}
