package shopping.model.Product;

/**
 * @author Quan Yang
 *
 */
public interface IProductBuilder {
	public void buildProductCategory(ProductCategory category);
	public void buildProductSupplier(ProductSupplier supplier);
	public void buildProductIdName(String id, String name);
	public void buildPriceAndCount(double unitPrice, int count);
	public void buildDiscount(boolean isDiscount, double discountRatio);
	public Product getProduct();
}
