/**
 * Abstract Colleague for UI framework
 */
package shopping.ui.abstractproduct;

import javax.swing.JFrame;

import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;

/**
 * @author Quan Yang
 *
 */
public abstract class APage extends JFrame {

	private static final long serialVersionUID = 1591777803698880800L;
	protected APageNavigator navigator;
	protected String pageName;
	public APage() {
	}
	public APage(String pageName, APageNavigator navigator) {
		this.navigator = navigator;
		this.pageName = pageName;
	}
	public APageNavigator getNavigator() {
		return navigator;
	}
	public void setNavigator(APageNavigator navigator) {
		this.navigator = navigator;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
//	public abstract void open();
//	public abstract void close();
	public abstract void navigate();
}
