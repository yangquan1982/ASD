/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.MainToPurState;
import framework.pagenavigation.State.ConcreteState.PurToMainState;

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
