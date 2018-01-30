/**
 * 
 */
package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopping.dto.CustomerDTO;
import shopping.dto.ProductCategoryDTO;

/**
 * @author Quan Yang
 *
 */
public class ProductCategoryDAO implements IProductCategoryDAO {
	private IDbConnection dbConnection;
	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#getCategoryById(java.lang.String)
	 */
	public ProductCategoryDTO getCategoryById(String id) throws SQLException {
		Connection connection = dbConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProductCategory WHERE categoryid=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return extractCustomerFromResultSet(rs);
        }
		return null;
	}
    private ProductCategoryDTO extractCustomerFromResultSet(ResultSet rs) throws SQLException {
    	ProductCategoryDTO category = new ProductCategoryDTO();
    	category.setId(rs.getString("categoryid"));
    	category.setCategoryName(rs.getString("categoryname"));
        return category;
    }

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#getCategoryByName(java.lang.String)
	 */
	public ProductCategoryDTO getCategoryByName(String name) throws SQLException {
		Connection connection = dbConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProductCategory WHERE categoryname=?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return extractCustomerFromResultSet(rs);
        }
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#insertCategory(shopping.dto.ProductCategoryDTO)
	 */
	public boolean insertCategory(ProductCategoryDTO Category) throws SQLException {
		
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
