/**
 * 
 */
package shopping.bus;

import java.util.List;

import javax.swing.table.TableModel;

import shopping.model.Product.Product;
import shopping.model.Product.ProductCategory;
import shopping.model.Product.ProductSupplier;

/**
 * @author Quan Yang
 *
 */
public interface IProductManager {
	public ProductCategory getProductCategoryById(String id);
	public ProductCategory getProductCategoryByName(String name);
	public List<ProductCategory> getAllProductCategories();
	public boolean addProductCategory(ProductCategory category);
	public ProductSupplier getProductSupplierById(String id);
	public ProductSupplier getProductSupplierByName(String name);
	public boolean addProductSupplier(ProductSupplier supplier);
	public boolean updateProductSupplier(ProductSupplier supplier);
	public List<ProductSupplier> getAllProductSuppliers();
	public Product getProductById(String id);
	public Product getProductByName(String name);
	public void getAllProducts();
	public boolean addNewProduct(Product product);
	public boolean addProduct(Product product);
	public boolean removeProducts(List<Product> products);
	public boolean updateProduct(Product product);
	public void clearProductList();
	public boolean removeProductsById(String[] ids);
	public TableModel setAllProductsToTableModel();
	public TableModel setOneProductToTableModel();
}
