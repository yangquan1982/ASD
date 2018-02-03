/**
 * 
 */
package shopping.ui.framework.pagefactory;

import shopping.ui.MainPanel;
import shopping.ui.framework.APage;

/**
 * @author Quan Yang
 *
 */
public class MainPanelFactory implements IPageFactory {
	private static IPageFactory factory = new MainPanelFactory();
	private MainPanelFactory() {}
	public static IPageFactory getFactory() {
		return factory;
	}
	@Override
	public APage createPage() {
		return MainPanel.INSTANCE;
	}

}
