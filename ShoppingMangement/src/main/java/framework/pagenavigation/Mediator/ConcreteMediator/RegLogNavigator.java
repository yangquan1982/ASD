/**
 * 
 */
package framework.pagenavigation.Mediator.ConcreteMediator;

import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;
import framework.pagenavigation.State.ConcreteState.LogToRegState;
import framework.pagenavigation.State.ConcreteState.RegToLogState;

/**
 * @author Quan Yang
 *
 */
public class RegLogNavigator extends APageNavigator {
	
	public RegLogNavigator() {
		super();
		this.fromAToBState = new RegToLogState(this);
		this.fromBToAState = new LogToRegState(this);
	}
	@Override
	public void navigate() {

	}
}
