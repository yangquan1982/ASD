/**
 * 
 */
package shopping.ui.framework.navigator;

import shopping.ui.framework.navigator.state.INavigatorState;

/**
 * @author Quan Yang
 *
 */
public class MainPListNavigator extends APageNavigator {
	private INavigatorState mainToPListState;
	private INavigatorState pListToMainState;
	private INavigatorState curState;
	public MainPListNavigator() {
		super();
	}
	@Override
	public void navigate() {
		
	}

}
