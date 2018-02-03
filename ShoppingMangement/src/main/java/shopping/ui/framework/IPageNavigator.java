/**
 * Mediator Interface for UI framework
 */
package shopping.ui.framework;

/**
 * @author Quan Yang
 *
 */
public interface IPageNavigator {
	public void addPage(APage page);
	public void navigate();
}
