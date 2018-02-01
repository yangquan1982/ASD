/**
 * 
 */
package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import shopping.dto.CustomerDTO;
import shopping.dto.ProductCategoryDTO;

/**
 * @author Quan Yang
 *
 */
public class ProductCategoryDAO implements IProductCategoryDAO {
	private IDbConnection dbConnection;
	
	public ProductCategoryDAO() {
		dbConnection = new DbConnection();
	}
	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#getCategoryById(java.lang.String)
	 */
	@Override
	public ProductCategoryDTO getCategoryById(String id) throws SQLException {
		Connection connection = dbConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProductCategory WHERE id=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return extractProductCategoryFromResultSet(rs);
        }
		return null;
	}
    private ProductCategoryDTO extractProductCategoryFromResultSet(ResultSet rs) throws SQLException {
    	ProductCategoryDTO category = new ProductCategoryDTO();
    	category.setId(rs.getString("id"));
    	category.setCategoryName(rs.getString("categoryName"));
        return category;
    }

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#getCategoryByName(java.lang.String)
	 */
    @Override
	public ProductCategoryDTO getCategoryByName(String name) throws SQLException {
		Connection connection = dbConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProductCategory WHERE categoryName=?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return extractProductCategoryFromResultSet(rs);
        }
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#insertCategory(shopping.dto.ProductCategoryDTO)
	 */
    @Override
	public boolean insertCategory(ProductCategoryDTO category) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ProductCategory VALUES (?, ?)");
//            if (category.getId()==null) {
//            	category.setId(UUID.randomUUID().toString());
//			}
            ps.setString(1, category.getId());
            ps.setString(2, category.getCategoryName());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return false;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#deleteCategory(shopping.dto.ProductCategoryDTO)
	 */
    @Override
	public boolean deleteCategory(ProductCategoryDTO Category) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM ProductCategory WHERE id=?");
            ps.setString(1, Category.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return false;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductCategoryDAO#updateCategory(shopping.dto.ProductCategoryDTO)
	 */
    @Override
	public boolean updateCategory(ProductCategoryDTO category) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE ProductCategory SET categoryName=? WHERE id=?");
            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return false;
	}
	@Override
	public List<ProductCategoryDTO> getAllCategories() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
