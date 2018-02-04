/**
 * Abstract Colleague for UI framework
 */
package shopping.ui.abstractproduct;

import javax.swing.JFrame;

import framework.pagenavigation.FactoryMethod.page.EPageName;
import framework.pagenavigation.Mediator.AbstractMediator.APageNavigator;

/**
 * @author Quan Yang
 *
 */
public abstract class APage extends JFrame {

	private static final long serialVersionUID = 1591777803698880800L;
	protected APageNavigator navigator;
	protected EPageName name;
	public APage() {
	}
	public APage(EPageName name, APageNavigator navigator) {
		this.navigator = navigator;
		this.name = name;
	}
	public APageNavigator getNavigator() {
		return navigator;
	}
	public void setNavigator(APageNavigator navigator) {
		this.navigator = navigator;
	}
	public EPageName getPageName() {
		return name;
	}
	public void setPageName(EPageName name) {
		this.name = name;
	}
	public void openItself() {//Template Method
		open();
	}
	public abstract void open();
//	public abstract void close();
	public abstract void navigate();
}
