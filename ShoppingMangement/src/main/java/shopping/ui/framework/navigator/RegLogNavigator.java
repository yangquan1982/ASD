/**
 * 
 */
package shopping.ui.framework.navigator;

import shopping.ui.framework.navigator.state.LogToRegState;
import shopping.ui.framework.navigator.state.RegToLogState;

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
