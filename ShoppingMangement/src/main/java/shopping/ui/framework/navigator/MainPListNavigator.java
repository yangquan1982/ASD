/**
 * 
 */
package shopping.ui.framework.navigator;

import shopping.ui.framework.navigator.state.MainToPListState;
import shopping.ui.framework.navigator.state.PListToMainState;

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
