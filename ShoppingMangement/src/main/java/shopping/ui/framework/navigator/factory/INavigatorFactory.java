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
	public APage createPageA();
	public APage createPageB();
	public APageNavigator createNavigator();
}
