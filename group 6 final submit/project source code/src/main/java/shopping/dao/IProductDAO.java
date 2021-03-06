package shopping.dao;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import shopping.dto.ProductDTO;

/**
 * @author Quan Yang
 *
 */
public interface IProductDAO {
	ProductDTO getProductById(String id) throws SQLException;
	List<ProductDTO> getProductsByName(String name) throws SQLException;
	List<ProductDTO> getProductsByCategoryName(String categoryName) throws SQLException;
	List<ProductDTO> getProductsBySupplierName(String supplierName) throws SQLException;
	List<ProductDTO> getAllProducts() throws SQLException;
	boolean insertProduct(ProductDTO product) throws SQLException;
	boolean deleteProduct(ProductDTO product) throws SQLException;
	boolean updateProduct(ProductDTO product) throws SQLException;
	ResultSetMetaData getMetaData() throws SQLException;
}
