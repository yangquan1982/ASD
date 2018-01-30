/**
 * 
 */
package shopping.dao;

import java.sql.SQLException;

import shopping.dto.ProductSupplierDTO;

/**
 * @author Quan Yang
 *
 */
public class ProductSupplierDAO implements IProductSupplierDAO {

	/* (non-Javadoc)
	 * @see shopping.dao.IProductSupplierDAO#getSupplierById(java.lang.String)
	 */
	@Override
	public ProductSupplierDTO getSupplierById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductSupplierDAO#getSupplierByName(java.lang.String)
	 */
	@Override
	public ProductSupplierDTO getSupplierByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductSupplierDAO#insertSupplier(shopping.dto.ProductSupplierDTO)
	 */
	@Override
	public boolean insertSupplier(ProductSupplierDTO supplier) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductSupplierDAO#deleteSupplier(shopping.dto.ProductSupplierDTO)
	 */
	@Override
	public boolean deleteSupplier(ProductSupplierDTO supplier) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see shopping.dao.IProductSupplierDAO#updateSupplier(shopping.dto.ProductSupplierDTO)
	 */
	@Override
	public boolean updateSupplier(ProductSupplierDTO supplier) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
