/**
 * 
 */
package shopping.ui.framework;

import java.awt.Component;

/**
 * @author Quan Yang
 *
 */
public interface IComponentFactory {
	public Component createComponent();
	public Component createComponent(String name);
}
