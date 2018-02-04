/**
 * 
 */
package shopping.ui.framework.navigator;

import shopping.ui.framework.navigator.state.BillToPurState;
import shopping.ui.framework.navigator.state.PurToBillState;

/**
 * @author Quan Yang
 *
 */
public class PurchaseBillNavigator extends APageNavigator {

	public PurchaseBillNavigator() {
		super();
		this.fromAToBState = new PurToBillState(this);
		this.fromBToAState = new BillToPurState(this);
	}
	
	@Override
	public void navigate() {
		
	}

}
