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
public interface IProductCategoryDAO {
	ProductCategoryDTO getCategoryById(String id) throws SQLException;
	ProductCategoryDTO getCategoryByName(String name) throws SQLException;
	boolean insertCategory(ProductCategoryDTO Category) throws SQLException;
	boolean deleteCategory(ProductCategoryDTO Category) throws SQLException;
	boolean updateCategory(ProductCategoryDTO Category) throws SQLException;
}
