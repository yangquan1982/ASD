/**
 * 
 */
package shopping.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import shopping.bus.IProductManager;
import shopping.bus.ProductManager;

/**
 * @author Quan Yang
 *
 */
public class ProductList {
	private List<Product> products;
	private IProductManager manager;

	public ProductList() {
		products = new ArrayList<Product>();
		manager = new ProductManager(this);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public boolean addProduct(Product product) {
		return manager.addProduct(product);
	}
	public boolean removeProducts(List<Product> products) {
		return manager.removeProducts(products);
	}
	public boolean updateProduct(Product product) {
		return manager.updateProduct(product);
	}
}
