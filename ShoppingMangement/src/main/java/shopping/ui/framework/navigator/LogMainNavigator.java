/**
 * 
 */
package shopping.ui.framework.navigator;

import java.util.List;

import shopping.ui.framework.navigator.state.INavigatorState;

/**
 * @author Quan Yang
 *
 */
public class LogMainNavigator extends APageNavigator {
	private INavigatorState logToMainState;
	private INavigatorState mainToLogState;
	private INavigatorState curState;
	public LogMainNavigator() {
		super();
	}
	@Override
	public void navigate() {
		
	}
}
