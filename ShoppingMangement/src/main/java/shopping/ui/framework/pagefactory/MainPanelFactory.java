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
	private String customName;
	private static IPageFactory factory = new MainPanelFactory();
	private MainPanelFactory() {}
	
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public static IPageFactory getFactory() {
		return factory;
	}
	@Override
	public APage createPage() {
		return MainPanel.getInstance(customName);
	}
}
