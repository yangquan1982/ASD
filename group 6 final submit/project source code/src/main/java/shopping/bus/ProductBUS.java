package shopping.bus;
import shopping.dao.ProductDAO;
import shopping.dto.ProductDTO;
import shopping.model.Product.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBUS{

    private ProductDAO productDAO;

    private ProductBUS() {
        productDAO = new ProductDAO();
    }

    private static ProductBUS productBUS;

    public static ProductBUS getProductBUS() {
        if(productBUS == null) {
            productBUS = new ProductBUS();
        }

        return productBUS;
    }


    public Product getProductDetails(String id) {
//
//        try {
//            ProductDO product = productDAO.getProduct(id);
//            if(product != null) {
//                return new Product(product.getId(), product.getProductName(), product.getUnitCost());
//            }
//        } catch (SQLException ex) {
//        }
//
      return null;
    }


    public List<Product> getAllProducts() throws SQLException {
        List<ProductDTO> productDOList = productDAO.getAllProducts();
        if(productDOList != null) {
            List<Product> products = new ArrayList<Product>();
            for(ProductDTO productDTO : productDOList) {
                products.add(new Product(productDTO.getId(), productDTO.getProductName(), productDTO.getUnitPrice()));
            }
            return products;
        }

        return null;
    }



}