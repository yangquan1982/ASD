/**
 * 
 */
package shopping.ui.framework.navigator.state;

import shopping.ui.framework.navigator.APageNavigator;

/**
 * @author tbg12
 *
 */
public class MainToPurState extends INavigatorState {
	
	public MainToPurState(APageNavigator navigator) {
		super(ENavState.FROMATOB, navigator);
	}

	@Override
	public void navigate() {
		
	}

}
