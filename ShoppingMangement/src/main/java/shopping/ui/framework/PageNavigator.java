/**
 * 
 */
package shopping.ui.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quan Yang
 *
 */
public class PageNavigator implements IPageNavigator {
	private List<APage> pages;
	
	public PageNavigator() {
		this.pages = new ArrayList<APage>();
	}
	/* (non-Javadoc)
	 * @see shopping.ui.framework.IPageNavigator#addPage(shopping.ui.framework.APage)
	 */
	@Override
	public void addPage(APage page) {
		this.pages.add(page);
	}

	/* (non-Javadoc)
	 * @see shopping.ui.framework.IPageNavigator#navigate()
	 */
	@Override
	public void navigate() {
		
	}

}
