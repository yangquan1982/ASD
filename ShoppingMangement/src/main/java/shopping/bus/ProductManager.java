/**
 * 
 */
package shopping.bus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import shopping.dao.*;
import shopping.dto.*;
import shopping.model.Product.*;

/**
 * @author Quan Yang
 *
 */
public class ProductManager implements IProductManager {
	private ProductList list;
	private List<ProductCategory> catehories;
	private List<ProductSupplier> suppliers;
	private IProductDAO productDao;
	private IProductCategoryDAO categoryDao;
	private IProductSupplierDAO supplierDao;
	
	public ProductManager(ProductList list) {
		this.list = list;
		this.catehories = new ArrayList<ProductCategory>();
		this.suppliers = new ArrayList<ProductSupplier>();
		this.productDao = new ProductDAO();
		this.categoryDao = new ProductCategoryDAO();
		this.supplierDao = new ProductSupplierDAO();
	}
	
	/* (non-Javadoc)
	 * @see shopping.bus.IProductManager#addProduct(shopping.model.Product.Product)
	 */
	@Override
	public boolean addProduct(Product product) {
		return list.getProducts().add(product);
	}

	/* (non-Javadoc)
	 * @see shopping.bus.IProductManager#removeProducts(java.util.List)
	 */
	@Override
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
	@Override
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

	@Override
	public Product getProductById(String id) {
		try {
			ProductDTO productDTO = productDao.getProductById(id);
			if (productDTO != null) {
				IProductBuilder productBuilder = new ProductBuilder();
				productBuilder.buildProductIdName(productDTO.getId(), productDTO.getProductName());
				ProductCategory category = getProductCategoryById(productDTO.getProductCategoryId());
				productBuilder.buildProductCategory(category);
				ProductSupplier supplier = getProductSupplierById(productDTO.getProductSupplierId());
				productBuilder.buildProductSupplier(supplier);
				productBuilder.buildPriceAndCount(productDTO.getUnitPrice(), productDTO.getTotalCnt());
				productBuilder.buildDiscount(productDTO.isDiscount(), productDTO.getDiscountRatio());
				return productBuilder.getProduct();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getProductByName(String name) {
		try {
			ProductDTO productDTO = productDao.getProductByName(name);
			if (productDTO != null) {
				IProductBuilder productBuilder = new ProductBuilder();
				productBuilder.buildProductIdName(productDTO.getId(), productDTO.getProductName());
				ProductCategory category = getProductCategoryById(productDTO.getProductCategoryId());
				productBuilder.buildProductCategory(category);
				ProductSupplier supplier = getProductSupplierById(productDTO.getProductSupplierId());
				productBuilder.buildProductSupplier(supplier);
				productBuilder.buildPriceAndCount(productDTO.getUnitPrice(), productDTO.getTotalCnt());
				productBuilder.buildDiscount(productDTO.isDiscount(), productDTO.getDiscountRatio());
				return productBuilder.getProduct();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TableModel setToTableModel() {
		// Get column names
		Vector<String> columnNames = new Vector<String>();
		// Get all rows.
	    Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
	    
	    return new DefaultTableModel(rows, columnNames);
	}

	@Override
	public ProductCategory getProductCategoryById(String id) {
		try {
			ProductCategoryDTO categoryDTO = categoryDao.getCategoryById(id);
			if (categoryDTO != null) {
				return new ProductCategory(categoryDTO.getId(), categoryDTO.getCategoryName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductCategory getProductCategoryByName(String name) {
		try {
			ProductCategoryDTO categoryDTO = categoryDao.getCategoryByName(name);
			if (categoryDTO != null) {
				return new ProductCategory(categoryDTO.getId(), categoryDTO.getCategoryName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProductCategory> getAllProductCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProductCategory(ProductCategory category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductSupplier getProductSupplierById(String id) {
		try {
			ProductSupplierDTO supplierDTO = supplierDao.getSupplierById(id);
			if (supplierDTO != null) {
				return new ProductSupplier(supplierDTO.getId(), supplierDTO.getName(),
						supplierDTO.getAddress(), supplierDTO.getPhoneNum());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductSupplier getProductSupplierByName(String name) {
		try {
			ProductSupplierDTO supplierDTO = supplierDao.getSupplierByName(name);
			if (supplierDTO != null) {
				return new ProductSupplier(supplierDTO.getId(), supplierDTO.getName(),
						supplierDTO.getAddress(), supplierDTO.getPhoneNum());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addProductSupplier(ProductSupplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProductSupplier(ProductSupplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductSupplier> getAllProductSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}
}
