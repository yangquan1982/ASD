/**
 * 
 */
package shopping.dao;

import java.sql.SQLException;
import java.util.List;

import shopping.dto.ProductSupplierDTO;

/**
 * @author Quan Yang
 *
 */
public interface IProductSupplierDAO {
	ProductSupplierDTO getSupplierById(String id) throws SQLException;
	List<ProductSupplierDTO> getSuppliersByName(String name) throws SQLException;
	ProductSupplierDTO getSupplierByName(String name) throws SQLException;
	List<ProductSupplierDTO> getAllSuppliers() throws SQLException;
	boolean insertSupplier(ProductSupplierDTO supplier) throws SQLException;
	boolean deleteSupplier(ProductSupplierDTO supplier) throws SQLException;
	boolean updateSupplier(ProductSupplierDTO supplier) throws SQLException;
}
