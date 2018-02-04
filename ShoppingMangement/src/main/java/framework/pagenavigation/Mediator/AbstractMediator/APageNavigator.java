/**
 * Mediator Interface for UI framework
 */
package framework.pagenavigation.Mediator.AbstractMediator;

import java.util.ArrayList;
import java.util.List;

import framework.pagenavigation.State.AbstractState.INavigatorState;
import shopping.ui.abstractproduct.APage;

/**
 * @author Quan Yang
 *
 */
public abstract class APageNavigator {
	protected List<APage> pages;
	protected INavigatorState fromAToBState;
	protected INavigatorState fromBToAState;
	protected INavigatorState currentState;
	public APageNavigator() {
		this.pages = new ArrayList<APage>();
	}
	public List<APage> getPages() {
		return this.pages;
	}
	public INavigatorState getCurrentState() {
		return this.currentState;
	}
	public void setCurrentState(INavigatorState currentState) {
		this.currentState = currentState;
	}
	public void setPages(List<APage> pages) {
		this.pages = pages;
	}
	public INavigatorState getFromAToBState() {
		return this.fromAToBState;
	}
	public void setFromAToBState(INavigatorState fromAToBState) {
		this.fromAToBState = fromAToBState;
	}
	public INavigatorState getFromBToAState() {
		return this.fromBToAState;
	}
	public void setFromBToAState(INavigatorState fromBToAState) {
		this.fromBToAState = fromBToAState;
	}
	public void addPage(APage page) {
		this.pages.add(page);
	}
	public abstract void navigate();
}
