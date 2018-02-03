/**
 * Mediator Interface for UI framework
 */
package shopping.ui.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quan Yang
 *
 */
public abstract class APageNavigator {
	protected List<APage> pages;
	protected APageNavigator() {
		pages = new ArrayList<APage>();
	}
	protected void addPage(APage page) {
		pages.add(page);
	}
	public abstract void navigate();
}
