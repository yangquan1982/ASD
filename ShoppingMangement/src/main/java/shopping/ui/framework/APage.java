/**
 * Abstract Colleague for UI framework
 */
package shopping.ui.framework;

import javax.swing.JFrame;

/**
 * @author Quan Yang
 *
 */
public abstract class APage extends JFrame {
	protected APageNavigator navigator;
	protected String pageName;
	public APage() {
	}
	public APage(APageNavigator navigator, String pageName) {
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
	public abstract void open();
	public abstract void close();
}
