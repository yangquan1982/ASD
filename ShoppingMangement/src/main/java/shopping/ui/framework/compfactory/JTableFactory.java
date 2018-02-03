/**
 * 
 */
package shopping.ui.framework.compfactory;

import java.awt.Component;

import javax.swing.JTable;

/**
 * @author Quan Yang
 *
 */
public class JTableFactory implements IComponentFactory {
	private static IComponentFactory factory = new JTableFactory();
	private JTableFactory() {}
	public static IComponentFactory getFactory() {
		return factory;
	}
	@Override
	public Component createComponent() {
		return new JTable();
	}
	@Override
	public Component createComponent(String name) {
		return new JTable();
	}
}
