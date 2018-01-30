/**
 * 
 */
package shopping.dao;

import java.sql.SQLException;

import shopping.dto.ProductDTO;

/**
 * @author Quan Yang
 *
 */
public class ProductDAO implements IProductDAO {

	/* (non-Javadoc)
	 * @see shopping.dao.IProductDAO#getProductById(java.lang.String)
	 */
	public ProductDTO getProductById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductDAO#getProductByName(java.lang.String)
	 */
	public ProductDTO getProductByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductDAO#insertProduct(shopping.dto.ProductDTO)
	 */
	public boolean insertProduct(ProductDTO product) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductDAO#deleteProduct(shopping.dto.ProductDTO)
	 */
	public boolean deleteProduct(ProductDTO product) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductDAO#updateProduct(shopping.dto.ProductDTO)
	 */
	public boolean updateProduct(ProductDTO product) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
