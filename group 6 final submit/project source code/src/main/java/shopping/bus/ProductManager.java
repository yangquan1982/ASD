/**
 * 
 */
package shopping.bus;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
	private List<ProductCategory> categories;
	private List<ProductSupplier> suppliers;
	private IProductDAO productDao;
	private IProductCategoryDAO categoryDao;
	private IProductSupplierDAO supplierDao;
	private static ProductManager productManager;
	public ProductManager() {
	}
	public static ProductManager getProductManager(ProductList list) {
		if (productManager==null) {
			productManager = new ProductManager();
			productManager.setCatehories(new ArrayList<ProductCategory>());
			productManager.setSuppliers(new ArrayList<ProductSupplier>());
			productManager.setProductDao(new ProductDAO());
			productManager.setCategoryDao(new ProductCategoryDAO());
			productManager.setSupplierDao(new ProductSupplierDAO());
			productManager.setList(list);
		}
		return productManager;
	}
	
	public ProductList getList() {
		return list;
	}
	public void setList(ProductList list) {
		this.list = list;
	}
	public Product getOneProduct() {
		return oneProduct;
	}
	public void setOneProduct(Product oneProduct) {
		this.oneProduct = oneProduct;
	}
	public List<ProductCategory> getCatehories() {
		return categories;
	}
	public void setCatehories(List<ProductCategory> catehories) {
		this.categories = catehories;
	}
	public List<ProductSupplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<ProductSupplier> suppliers) {
		this.suppliers = suppliers;
	}
	public IProductDAO getProductDao() {
		return productDao;
	}
	public void setProductDao(IProductDAO productDao) {
		this.productDao = productDao;
	}
	public IProductCategoryDAO getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(IProductCategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}
	public IProductSupplierDAO getSupplierDao() {
		return supplierDao;
	}
	public void setSupplierDao(IProductSupplierDAO supplierDao) {
		this.supplierDao = supplierDao;
	}
	public static ProductManager getProductManager() {
		return productManager;
	}
	public static void setProductManager(ProductManager productManager) {
		ProductManager.productManager = productManager;
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
		ProductDTO productDTO = createProductDTOFromProduct(product);
		try {
			productDao.deleteProduct(productDTO);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	private ProductDTO createProductDTOFromProduct(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setProductName(product.getName());
		productDTO.setProductCategoryId(product.getCategory().getId());
		productDTO.setProductSupplierId(product.getSupplier().getId());
		productDTO.setUnitPrice(product.getUnitPrice());
		productDTO.setTotalCnt(product.getTotalCnt());
		productDTO.setDiscount(product.isDiscount());
		productDTO.setDiscountRatio(product.getDiscountRatio());
		return productDTO;
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
			try {
				productDao.updateProduct(createProductDTOFromProduct(product));
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	public List<Product> getProductsByName(String name) {
		try {
			List<Product> products = new ArrayList<Product>();
			List<ProductDTO> productDTOs = productDao.getProductsByName(name);
			if (productDTOs != null && !productDTOs.isEmpty()) {
				for (ProductDTO productDTO : productDTOs) {
					IProductBuilder productBuilder = new ProductBuilder();
					productBuilder.buildProductIdName(productDTO.getId(), productDTO.getProductName());
					ProductCategory category = getProductCategoryById(productDTO.getProductCategoryId());
					productBuilder.buildProductCategory(category);
					ProductSupplier supplier = getProductSupplierById(productDTO.getProductSupplierId());
					productBuilder.buildProductSupplier(supplier);
					productBuilder.buildPriceAndCount(productDTO.getUnitPrice(), productDTO.getTotalCnt());
					productBuilder.buildDiscount(productDTO.isDiscount(), productDTO.getDiscountRatio());
					products.add(productBuilder.getProduct());
				}
				return products;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void getAllProducts() {
		list.getProducts().clear();
		try {
			List<ProductDTO> productDTOs = productDao.getAllProducts();
			if (productDTOs != null) {
				for (ProductDTO productDTO : productDTOs) {
					if (productDTO != null) {
						IProductBuilder productBuilder = new ProductBuilder();
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
	public List<ProductCategory> getProductCategoriesByName(String name) {
		try {
			List<ProductCategoryDTO> categoryDTOs = categoryDao.getCategoriesByName(name);
			List<ProductCategory> pCategories = new ArrayList<ProductCategory>();
			if (categoryDTOs != null && !categoryDTOs.isEmpty()) {
				for (ProductCategoryDTO pCategoryDTO : categoryDTOs) {
					pCategories.add(new ProductCategory(pCategoryDTO.getId(), 
							pCategoryDTO.getCategoryName()));
				}
				return pCategories;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	private ProductCategory createCategoryFromCategoryDTO(ProductCategoryDTO categoryDTO) {
		ProductCategory category = new ProductCategory();
		category.setId(categoryDTO.getId());
		category.setCategoryName(categoryDTO.getCategoryName());
		return category;
	}
	@Override
	public void getAllProductCategories() {
		try {
			List<ProductCategoryDTO> categoryDTOs = categoryDao.getAllCategories();
			for (ProductCategoryDTO productCategoryDTO : categoryDTOs) {
				categories.add(createCategoryFromCategoryDTO(productCategoryDTO));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean addProductCategory(ProductCategory category) {
		try {
			if (categoryDao.getCategoryByName(category.getCategoryName())==null) {
				return categoryDao.insertCategory(new ProductCategoryDTO(category.getId(), 
						category.getCategoryName()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public List<ProductSupplier> getProductSuppliersByName(String name) {
		try {
			List<ProductSupplier> pSuppliers = new ArrayList<ProductSupplier>();
			List<ProductSupplierDTO> supplierDTO = supplierDao.getSuppliersByName(name);
			if (supplierDTO != null && !supplierDTO.isEmpty()) {
				for (ProductSupplierDTO productSupplierDTO : supplierDTO) {
					ProductSupplier pSupplier = new ProductSupplier();
					pSupplier.setId(productSupplierDTO.getId());
					pSupplier.setName(productSupplierDTO.getName());
					pSupplier.setAddress(productSupplierDTO.getAddress());
					pSupplier.setPhoneNum(productSupplierDTO.getPhoneNum());
					pSuppliers.add(pSupplier);
				}
				return pSuppliers;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addProductSupplier(ProductSupplier supplier) {
		try {
			List<ProductSupplierDTO> pSupplierDTOs = supplierDao.getAllSuppliers();
			boolean isExist = false;
			for (ProductSupplierDTO item : pSupplierDTOs) {
				if (item.getName().equals(supplier.getName()) 
						&& item.getAddress().equals(supplier.getAddress()) 
						&& item.getPhoneNum().equals(supplier.getPhoneNum())) {
					isExist = true;
					break;
				}
			}
			if (!isExist) {
				return supplierDao.insertSupplier(new ProductSupplierDTO(supplier.getId(), 
						supplier.getName(), supplier.getAddress(), supplier.getPhoneNum()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private ProductSupplier createSupplierFromSupplierDTO(ProductSupplierDTO supplierDTO) {
		ProductSupplier supplier = new ProductSupplier();
		supplier.setId(supplierDTO.getId());
		supplier.setName(supplierDTO.getName());
		supplier.setAddress(supplierDTO.getAddress());
		supplier.setPhoneNum(supplierDTO.getPhoneNum());
		return supplier;
	}
	private ProductSupplierDTO createSupplierDTOFromSupplier(ProductSupplier supplier) {
		ProductSupplierDTO supplierDTO = new ProductSupplierDTO();
		supplierDTO.setId(supplier.getId());
		supplierDTO.setName(supplier.getName());
		supplierDTO.setAddress(supplier.getAddress());
		supplierDTO.setPhoneNum(supplier.getPhoneNum());
		return supplierDTO;
	}
	@Override
	public boolean updateProductSupplier(ProductSupplier supplier) {
		boolean isExist = false;
		ProductSupplier toBeUpdated = null;
		for (ProductSupplier productSupplier : suppliers) {
			if (productSupplier.getId().equals(supplier.getId())) {
				isExist = true;
				toBeUpdated = productSupplier;
				break;
			}
		}
		if (isExist) {
			suppliers.set(suppliers.indexOf(toBeUpdated), supplier);
			try {
				supplierDao.updateSupplier(createSupplierDTOFromSupplier(supplier));
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Product Supplier: "+supplier.getName()+"does not exist!!!");
		return false;
	}

	@Override
	public void getAllProductSuppliers() {
		try {
			List<ProductSupplierDTO> supplierDTOs = supplierDao.getAllSuppliers();
			for (ProductSupplierDTO productSupplierDTO : supplierDTOs) {
				suppliers.add(createSupplierFromSupplierDTO(productSupplierDTO));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public boolean addNewProduct(Product product) {
		try {
			ProductDTO productDTO = new ProductDTO();
			ProductCategoryDTO categoryDTO = 
					categoryDao.getCategoryByName(product.getCategory().getCategoryName());
			if (categoryDTO == null) {
				String categoryId = UUID.randomUUID().toString();
				categoryDTO = new ProductCategoryDTO(categoryId,product.getCategory().getCategoryName());
				categoryDao.insertCategory(categoryDTO);
				productDTO.setProductCategoryId(categoryId);
			} else {
				product.getCategory().setId(categoryDTO.getId());
				productDTO.setProductCategoryId(categoryDTO.getId());
			}
			
			ProductSupplierDTO supplierDTO =
					supplierDao.getSupplierByName(product.getSupplier().getName());
			if (supplierDTO==null) {
				String supplierId = UUID.randomUUID().toString();
				supplierDTO = new ProductSupplierDTO(supplierId, product.getSupplier().getName(),
						product.getSupplier().getAddress(), product.getSupplier().getPhoneNum());
				supplierDao.insertSupplier(supplierDTO);
				productDTO.setProductSupplierId(supplierId);
			} else {
				if (supplierDTO.getAddress().equals(product.getSupplier().getAddress())
						&& supplierDTO.getPhoneNum().equals(product.getSupplier().getPhoneNum())) {
					product.getSupplier().setId(supplierDTO.getId());
					productDTO.setProductSupplierId(supplierDTO.getId());
				} else {
					String supplierId = UUID.randomUUID().toString();
					supplierDTO.setId(supplierId);
					supplierDTO.setAddress(product.getSupplier().getAddress());
					supplierDTO.setPhoneNum(product.getSupplier().getPhoneNum());
					supplierDao.insertSupplier(supplierDTO);
					productDTO.setProductSupplierId(supplierId);
				}
			}
			productDTO.setId(product.getId());
			productDTO.setProductName(product.getName());
			productDTO.setUnitPrice(product.getUnitPrice());
			productDTO.setTotalCnt(product.getTotalCnt());
			productDTO.setDiscount(product.isDiscount());
			productDTO.setDiscountRatio(product.getDiscountRatio());
			productDao.insertProduct(productDTO);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean removeProductById(String id) {
		Product product = getProductById(id);
		return removeProduct(product);
	}
	@Override
	public void clearProductList() {
		list.getProducts().clear();
	}
	@Override
	public boolean updateProductCategory(ProductCategory category) {
		boolean isExist = false;
		ProductCategory toBeUpdated = null;
		for (ProductCategory productCategory : categories) {
			if (productCategory.getId().equals(category.getId())) {
				isExist = true;
				toBeUpdated = productCategory;
			}
		}
		if (isExist) {
			categories.set(categories.indexOf(toBeUpdated), category);
			try {
				ProductCategoryDTO categoryDTO = new ProductCategoryDTO(category.getId(),
						category.getCategoryName());
				categoryDao.updateCategory(categoryDTO);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	private List<Product> getProductsByProductDTO(List<ProductDTO> productDTOs) {
		List<Product> products = new ArrayList<Product>();
		if (productDTOs != null && !productDTOs.isEmpty()) {
			for (ProductDTO productDTO : productDTOs) {
				IProductBuilder productBuilder = new ProductBuilder();
				productBuilder.buildProductIdName(productDTO.getId(), productDTO.getProductName());
				ProductCategory category = getProductCategoryById(productDTO.getProductCategoryId());
				productBuilder.buildProductCategory(category);
				ProductSupplier supplier = getProductSupplierById(productDTO.getProductSupplierId());
				productBuilder.buildProductSupplier(supplier);
				productBuilder.buildPriceAndCount(productDTO.getUnitPrice(), productDTO.getTotalCnt());
				productBuilder.buildDiscount(productDTO.isDiscount(), productDTO.getDiscountRatio());
				products.add(productBuilder.getProduct());
			}
			return products;
		}
		return null;
	}
	@Override
	public List<Product> getProductsByCategoryName(String categoryName) {
		try {
			return getProductsByProductDTO(productDao.getProductsByCategoryName(categoryName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Product> getProductsBySupplierName(String supplierName) {
		try {
			return getProductsByProductDTO(productDao.getProductsBySupplierName(supplierName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
