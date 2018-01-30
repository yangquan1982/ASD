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
public interface IProductSupplierDAO {
	ProductSupplierDTO getSupplierById(String id) throws SQLException;
	ProductSupplierDTO getSupplierByName(String name) throws SQLException;
	boolean insertSupplier(ProductSupplierDTO supplier) throws SQLException;
	boolean deleteSupplier(ProductSupplierDTO supplier) throws SQLException;
	boolean updateSupplier(ProductSupplierDTO supplier) throws SQLException;
}
