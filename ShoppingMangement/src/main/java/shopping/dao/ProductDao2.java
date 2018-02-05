package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dataaccess.ConnectionPool;
import framework.dataaccess.FacadeJDBCExecutor;
import shopping.dto.ProductCategoryDTO;
import shopping.dto.ProductDTO;
import shopping.dto.ProductSupplierDTO;


public class ProductDao2 implements IProductDAO {
    private FacadeJDBCExecutor executor;
    private ConnectionPool pool;
    
    public ProductDao2() {
        executor = new FacadeJDBCExecutor();
        try {
            pool = new ConnectionPool();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see shopping.dao.IProductDAO#getProductById(java.lang.String)
     */
    @Override
    public ProductDTO getProductById(String id) throws SQLException {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product WHERE id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractProductFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }

    /* (non-Javadoc)
     * @see shopping.dao.IProductDAO#getProductByName(java.lang.String)
     */
    @Override
    public List<ProductDTO> getProductsByName(String name) throws SQLException {
        Connection connection = pool.getConnection();
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product WHERE productName=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                productDTOs.add(extractProductFromResultSet(rs));
            }
            return productDTOs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }
    private ProductDTO extractProductFromResultSet(ResultSet rs) throws SQLException {
        ProductDTO product = new ProductDTO();
        product.setId(rs.getString("id"));
        product.setProductCategoryId(rs.getString("productCategoryId"));
        product.setProductName(rs.getString("productName"));
        product.setProductSupplierId(rs.getString("productSupplierId"));
        product.setUnitPrice(rs.getDouble("unitPrice"));
        product.setTotalCnt(rs.getInt("totalCnt"));
        if (rs.getInt("isDiscount")==1) {
            product.setDiscount(true);
        } else {
            product.setDiscount(false);
        }
        product.setDiscountRatio(rs.getDouble("discountRatio"));
        return product;
    }
    /* (non-Javadoc)
     * @see shopping.dao.IProductDAO#insertProduct(shopping.dto.ProductDTO)
     */
    @Override
    public boolean insertProduct(ProductDTO product) throws SQLException {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, product.getId());
            ps.setString(2, product.getProductCategoryId());
            ps.setString(3, product.getProductName());
            ps.setDouble(4, product.getUnitPrice());
            ps.setInt(5, product.getTotalCnt());
            ps.setDouble(6, product.getDiscountRatio());
            if (product.isDiscount()) {
                ps.setInt(7, 1);
            } else {
                ps.setInt(7, 0);
            }
            ps.setString(8, product.getProductSupplierId());
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
     * @see shopping.dao.IProductDAO#deleteProduct(shopping.dto.ProductDTO)
     */
    @Override
    public boolean deleteProduct(ProductDTO product) throws SQLException {
        /*
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM Product WHERE id=?");
            ps.setString(1, product.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        */
        String sql = "DELETE FROM Product WHERE id=" + product.getId();
        return executor.executeSQL(sql);
    }
    
    

    /* (non-Javadoc)
     * @see shopping.dao.IProductDAO#updateProduct(shopping.dto.ProductDTO)
     */
    @Override
    public boolean updateProduct(ProductDTO product) throws SQLException {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE Product SET productCategoryId=?, productName=?, unitPrice=?, "
                    + "totalCnt=?, discountRatio=?, isDiscount=?, productSupplierId=? WHERE id=?");
            ps.setString(1, product.getProductCategoryId());
            ps.setString(2, product.getProductName());
            ps.setDouble(3, product.getUnitPrice());
            ps.setInt(4, product.getTotalCnt());
            ps.setDouble(5, product.getDiscountRatio());
            if (product.isDiscount()) {
                ps.setInt(6, 1);
            } else {
                ps.setInt(6, 0);
            }
            ps.setString(7, product.getProductSupplierId());
            ps.setString(8, product.getId());
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
    public List<ProductDTO> getAllProducts() throws SQLException {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product");
            ResultSet rs = ps.executeQuery();
            List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
            while(rs.next())
            {
                productDTOs.add(extractProductFromResultSet(rs));
            }
            return productDTOs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        Connection connection = pool.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product");
        return ps.executeQuery().getMetaData();
    }

    @Override
    public List<ProductDTO> getProductsByCategoryName(String categoryName) throws SQLException {
        Connection connection = pool.getConnection();
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        IProductCategoryDAO categoryDAO = new ProductCategoryDAO();
        List<ProductCategoryDTO> productCategoryDTOs = categoryDAO.getCategoriesByName(categoryName);
        try {
            for (ProductCategoryDTO productCategoryDTO : productCategoryDTOs) {
                String productCategoryId = productCategoryDTO.getId();
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product WHERE productCategoryId=?");
                ps.setString(1, productCategoryId);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    productDTOs.add(extractProductFromResultSet(rs));
                }
            }
            return productDTOs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public List<ProductDTO> getProductsBySupplierName(String supplierName) throws SQLException {
        Connection connection = pool.getConnection();
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        IProductSupplierDAO supplierDAO = new ProductSupplierDAO();
        List<ProductSupplierDTO> productSupplierDTOs = supplierDAO.getSuppliersByName(supplierName);
        try {
            for (ProductSupplierDTO productSupplierDTO : productSupplierDTOs) {
                String productSupplierId = productSupplierDTO.getId();
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM Product WHERE productSupplierId=?");
                ps.setString(1, productSupplierId);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    productDTOs.add(extractProductFromResultSet(rs));
                }
            }
            return productDTOs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        return null;
    }

}
