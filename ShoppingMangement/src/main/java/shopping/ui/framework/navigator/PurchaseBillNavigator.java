/**
 * 
 */
package shopping.ui.framework.navigator;

import shopping.ui.framework.navigator.state.INavigatorState;

/**
 * @author Quan Yang
 *
 */
public class PurchaseBillNavigator extends APageNavigator {
	private INavigatorState purToBillState;
	private INavigatorState billToPurState;
	private INavigatorState curState;
	public PurchaseBillNavigator() {
		super();
	}
	@Override
	public void navigate() {
		
	}

}
