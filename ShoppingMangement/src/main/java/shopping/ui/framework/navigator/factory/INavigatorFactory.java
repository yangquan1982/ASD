/**
 * 
 */
package shopping.ui.framework.navigator.factory;

import shopping.ui.framework.*;
import shopping.ui.framework.navigator.APageNavigator;

/**
 * @author Quan Yang
 *
 */
public interface INavigatorFactory {
	public APage createSrcPage();
	public APage createDestPage();
	public APageNavigator createNavigator();
}
