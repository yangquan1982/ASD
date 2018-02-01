/**
 * 
 */
package shopping.bus;

import java.lang.reflect.Field;
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
	private Product oneProduct;
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
	public void getAllProducts() {
		try {
			IProductBuilder productBuilder = new ProductBuilder();
			List<ProductDTO> productDTOs = productDao.getAllProducts();
			for (ProductDTO productDTO : productDTOs) {
				if (productDTO != null) {
					productBuilder.buildProductIdName(productDTO.getId(), productDTO.getProductName());
					ProductCategory category = getProductCategoryById(productDTO.getProductCategoryId());
					productBuilder.buildProductCategory(category);
					ProductSupplier supplier = getProductSupplierById(productDTO.getProductSupplierId());
					productBuilder.buildProductSupplier(supplier);
					productBuilder.buildPriceAndCount(productDTO.getUnitPrice(), productDTO.getTotalCnt());
					productBuilder.buildDiscount(productDTO.isDiscount(), productDTO.getDiscountRatio());
					list.addProduct(productBuilder.getProduct());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	private Vector<String> getTableColumnNames() {
		Vector<String> columnNames = new Vector<String>();
		columnNames.addElement("Product ID");
		columnNames.addElement("Product Name");
		columnNames.addElement("Product Category");
		columnNames.addElement("Product Supplier");
		columnNames.addElement("Supplier Address");
		columnNames.addElement("Supplier Phone Number");
		columnNames.addElement("Unit Price");
		columnNames.addElement("Total Count");
		columnNames.addElement("Is Discount");
		columnNames.addElement("Discount Ratio");
		return columnNames;
	}
	private Vector<Vector<String>> getAllProductsTableData(){
		if (list.getProducts().isEmpty()) {
			return null;
		}
	    Vector<Vector<String>> rows = new Vector<Vector<String>>();
	    for (Product product : list.getProducts()) {
			Vector<String> newRow = new Vector<String>();
			newRow.addElement(product.getId());
			newRow.addElement(product.getName());
			newRow.addElement(product.getCategory().getCategoryName());
			newRow.addElement(product.getSupplier().getName());
			newRow.addElement(product.getSupplier().getAddress());
			newRow.addElement(product.getSupplier().getPhoneNum());
			newRow.addElement(Double.toString(product.getUnitPrice()));
			newRow.addElement(Integer.toString(product.getTotalCnt()));
			if (product.isDiscount()) {
				newRow.addElement("True");
			} else {
				newRow.addElement("False");
			}
			newRow.addElement(Double.toString(product.getDiscountRatio()));
		    rows.addElement(newRow);
		}
	    return rows;
	}
	@Override
	public TableModel setAllProductsToTableModel() {
		// Get column names
		Vector<String> columnNames = getTableColumnNames();
		// Get all rows.
		Vector<Vector<String>> rows = getAllProductsTableData();
		if (rows == null) {
			System.out.println("Product List is empty!!!");
			return null;
		}
	    return new DefaultTableModel(rows, columnNames);
	}
	private Vector<Vector<String>> getOneProductTableData() {
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		Vector<String> newRow = new Vector<String>();
		newRow.addElement(oneProduct.getId());
		newRow.addElement(oneProduct.getName());
		newRow.addElement(oneProduct.getCategory().getCategoryName());
		newRow.addElement(oneProduct.getSupplier().getName());
		newRow.addElement(oneProduct.getSupplier().getAddress());
		newRow.addElement(oneProduct.getSupplier().getPhoneNum());
		newRow.addElement(Double.toString(oneProduct.getUnitPrice()));
		newRow.addElement(Integer.toString(oneProduct.getTotalCnt()));
		if (oneProduct.isDiscount()) {
			newRow.addElement("True");
		} else {
			newRow.addElement("False");
		}
		newRow.addElement(Double.toString(oneProduct.getDiscountRatio()));
	    rows.addElement(newRow);
	    return rows;
	}
	@Override
	public TableModel setOneProductToTableModel() {
		// Get column names
		Vector<String> columnNames = getTableColumnNames();
		// Get all rows.
		Vector<Vector<String>> rows = getOneProductTableData();
		if (rows == null) {
			System.out.println("Product doesn't exist!!!");
			return null;
		}
		return new DefaultTableModel(rows, columnNames);
	}
}
