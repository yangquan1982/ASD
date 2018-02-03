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
	protected IPageNavigator navigator;
	protected String pageName;
	public APage() {
	}
	public APage(IPageNavigator navigator, String pageName) {
		this.navigator = navigator;
		this.pageName = pageName;
	}
	public IPageNavigator getNavigator() {
		return navigator;
	}
	public void setNavigator(IPageNavigator navigator) {
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
