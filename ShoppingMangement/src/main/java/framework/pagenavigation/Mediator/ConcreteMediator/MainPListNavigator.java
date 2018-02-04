/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.MainToPListState;
import framework.pagenavigation.State.ConcreteState.PListToMainState;

/**
 * @author Quan Yang
 *
 */
public class MainPListNavigator extends APageNavigator {
	
	public MainPListNavigator() {
		super();
		this.fromAToBState = new MainToPListState(this);
		this.fromBToAState = new PListToMainState(this);
	}

	@Override
	public void navigate() {
		
	}

}
