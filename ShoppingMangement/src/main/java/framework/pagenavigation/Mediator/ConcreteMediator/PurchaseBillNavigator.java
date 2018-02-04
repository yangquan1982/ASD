/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.BillToPurState;
import framework.pagenavigation.State.ConcreteState.PurToBillState;

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
