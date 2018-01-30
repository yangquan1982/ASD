/**
 * 
 */
package shopping.dao;

import java.sql.SQLException;

import shopping.dto.ProductCategoryDTO;

/**
 * @author Quan Yang
 *
 */
public class ProductCategoryDAO implements IProductCategoryDAO {

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#getCategoryById(java.lang.String)
	 */
	public ProductCategoryDTO getCategoryById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#getCategoryByName(java.lang.String)
	 */
	public ProductCategoryDTO getCategoryByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#insertCategory(shopping.dto.ProductCategoryDTO)
	 */
	public boolean insertCategory(ProductCategoryDTO Category) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#deleteCategory(shopping.dto.ProductCategoryDTO)
	 */
	public boolean deleteCategory(ProductCategoryDTO Category) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#updateCategory(shopping.dto.ProductCategoryDTO)
	 */
	public boolean updateCategory(ProductCategoryDTO Category) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
