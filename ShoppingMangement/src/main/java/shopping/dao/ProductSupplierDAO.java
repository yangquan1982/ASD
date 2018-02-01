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

import shopping.dto.ProductCategoryDTO;
import shopping.dto.ProductSupplierDTO;

/**
 * @author Quan Yang
 *
 */
public class ProductSupplierDAO implements IProductSupplierDAO {
	private IDbConnection dbConnection;
	
	public ProductSupplierDAO() {
		dbConnection = new DbConnection();
	}
	/* (non-Javadoc)
	 * @see shopping.dao.IProductSupplierDAO#getSupplierById(java.lang.String)
	 */
	@Override
	public ProductSupplierDTO getSupplierById(String id) throws SQLException {
		Connection connection = dbConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProductSupplier WHERE id=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return extractProductSupplierFromResultSet(rs);
        }
		return null;
	}
    private ProductSupplierDTO extractProductSupplierFromResultSet(ResultSet rs) throws SQLException {
    	ProductSupplierDTO supplier = new ProductSupplierDTO();
    	supplier.setId(rs.getString("id"));
    	supplier.setName(rs.getString("name"));
    	supplier.setAddress(rs.getString("address"));
    	supplier.setPhoneNum(rs.getString("phoneNum"));
        return supplier;
    }
	/* (non-Javadoc)
	 * @see shopping.dao.IProductSupplierDAO#getSupplierByName(java.lang.String)
	 */
	@Override
	public ProductSupplierDTO getSupplierByName(String name) throws SQLException {
		Connection connection = dbConnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM ProductSupplier WHERE name=?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return extractProductSupplierFromResultSet(rs);
        }
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductSupplierDAO#insertSupplier(shopping.dto.ProductSupplierDTO)
	 */
	@Override
	public boolean insertSupplier(ProductSupplierDTO supplier) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ProductSupplier VALUES (?, ?, ?, ?)");
//            if (supplier.getId()==null) {
//				supplier.setId(UUID.randomUUID().toString());
//			}
            ps.setString(1, supplier.getId());
            ps.setString(2, supplier.getName());
            ps.setString(3, supplier.getAddress());
            ps.setString(4, supplier.getPhoneNum());
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
	 * @see shopping.dao.IProductSupplierDAO#deleteSupplier(shopping.dto.ProductSupplierDTO)
	 */
	@Override
	public boolean deleteSupplier(ProductSupplierDTO supplier) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM ProductSupplier WHERE id=?");
            ps.setString(1, supplier.getId());
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
	 * @see shopping.dao.IProductSupplierDAO#updateSupplier(shopping.dto.ProductSupplierDTO)
	 */
	@Override
	public boolean updateSupplier(ProductSupplierDTO supplier) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE ProductSupplier SET name=?, address=?, phoneNum=? WHERE id=?");
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getAddress());
            ps.setString(3, supplier.getPhoneNum());
            ps.setString(4, supplier.getId());
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
	public List<ProductSupplierDTO> getAllSuppliers() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
