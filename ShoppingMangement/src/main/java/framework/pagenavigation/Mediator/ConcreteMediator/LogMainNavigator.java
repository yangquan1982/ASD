/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.LogToMainState;
import framework.pagenavigation.State.ConcreteState.MainToLogState;

/**
 * @author Quan Yang
 *
 */
public class LogMainNavigator extends APageNavigator {
	
	public LogMainNavigator() {
		super();
		this.fromAToBState = new LogToMainState(this);
		this.fromBToAState = new MainToLogState(this);
	}

	@Override
	public void navigate() {
		
	}
}
