/**
 * 
 */
package shopping.ui.framework.navigator.state;

import shopping.ui.framework.navigator.APageNavigator;

/**
 * @author Quan Yang
 *
 */
public abstract class INavigatorState {
	protected ENavState state;
	protected APageNavigator navigator;
	
	public INavigatorState(ENavState state, APageNavigator navigator) {
		this.state = state;
		this.navigator = navigator;
	}
	public ENavState getState() {
		return state;
	}
	public void setState(ENavState state) {
		this.state = state;
	}
	public abstract void navigate();
}
