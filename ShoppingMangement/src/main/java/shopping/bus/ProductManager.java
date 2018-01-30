/**
 * 
 */
package shopping.bus;

import java.util.List;

import shopping.model.Product.Product;
import shopping.model.Product.ProductList;

/**
 * @author Quan Yang
 *
 */
public class ProductManager implements IProductManager {
	private ProductList list;
	
	public ProductManager(ProductList list) {
		this.list = list;
	}

	/* (non-Javadoc)
	 * @see shopping.bus.IProductManager#addProduct(shopping.model.Product.Product)
	 */
	public boolean addProduct(Product product) {
		return list.getProducts().add(product);
	}

	/* (non-Javadoc)
	 * @see shopping.bus.IProductManager#removeProducts(java.util.List)
	 */
	public boolean removeProducts(List<Product> products) {
		for (Product product : products) {
			if (!removeProduct(product)) {
				return false;
			}
		}
		return true;
	}
	private boolean removeProduct(Product product) {
		return list.getProducts().remove(product);
	}
	/* (non-Javadoc)
	 * @see shopping.bus.IProductManager#updateProduct(shopping.model.Product.Product)
	 */
	public boolean updateProduct(Product product) {
		boolean isExist = false;
		Product toBeUpdated = null;
		for (Product item : list.getProducts()) {
			if (item.getId().equals(product.getId())) {
				isExist = true;
				toBeUpdated = item;
				break;
			}
		}
		if (isExist) {
			list.getProducts().set(list.getProducts().indexOf(toBeUpdated), product);
			return true;
		}
		System.out.println("Product: " + product.getName() + "does not exist!");
		return false;
	}

}
