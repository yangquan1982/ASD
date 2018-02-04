/**
 * 
 */
package shopping.ui.framework.navigator;

import shopping.ui.framework.navigator.state.LogToMainState;
import shopping.ui.framework.navigator.state.MainToLogState;

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
