/**
 * 
 */
package shopping.ui.framework.navigator;

import shopping.ui.framework.navigator.state.MainToPurState;
import shopping.ui.framework.navigator.state.PurToMainState;

/**
 * @author Quan Yang
 *
 */
public class MainPurchaseNavigator extends APageNavigator {
	
	public MainPurchaseNavigator() {
		super();
		this.fromAToBState = new MainToPurState(this);
		this.fromBToAState = new PurToMainState(this);
	}
	
	@Override
	public void navigate() {
		
	}
}
