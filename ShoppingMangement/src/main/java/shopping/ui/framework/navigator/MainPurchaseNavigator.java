/**
 * 
 */
package shopping.ui.framework.navigator;

import shopping.ui.framework.navigator.state.INavigatorState;

/**
 * @author Quan Yang
 *
 */
public class MainPurchaseNavigator extends APageNavigator {
	private INavigatorState mainToPurState;
	private INavigatorState purToMainState;
	private INavigatorState curState;
	public MainPurchaseNavigator() {
		super();
	}
	@Override
	public void navigate() {
		
	}
}
