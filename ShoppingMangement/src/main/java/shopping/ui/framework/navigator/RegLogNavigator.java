/**
 * 
 */
package shopping.ui.framework.navigator;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import shopping.ui.framework.navigator.state.INavigatorState;
import shopping.ui.framework.pagefactory.RegPageFactory;

/**
 * @author Quan Yang
 *
 */
public class RegLogNavigator extends APageNavigator {
	private INavigatorState regToLogState;
	private INavigatorState logToRegState;
	private INavigatorState curState;
	public INavigatorState getRegToLogState() {
		return regToLogState;
	}
	public void setRegToLogState(INavigatorState regToLogState) {
		this.regToLogState = regToLogState;
	}
	public INavigatorState getLogToRegState() {
		return logToRegState;
	}
	public void setLogToRegState(INavigatorState logToRegState) {
		this.logToRegState = logToRegState;
	}
	public INavigatorState getCurState() {
		return curState;
	}
	public void setCurState(INavigatorState curState) {
		this.curState = curState;
	}
	public RegLogNavigator() {
		super();
	}
	@Override
	public void navigate() {

	}
}
