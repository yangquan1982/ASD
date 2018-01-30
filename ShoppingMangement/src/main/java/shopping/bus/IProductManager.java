/**
 * 
 */
package shopping.bus;

import java.util.List;

import shopping.model.Product.Product;

/**
 * @author Quan Yang
 *
 */
public interface IProductManager {
	public boolean addProduct(Product product);
	public boolean removeProducts(List<Product> products);
	public boolean updateProduct(Product product);
}
