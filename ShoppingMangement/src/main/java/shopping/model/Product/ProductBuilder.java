package shopping.model.Product;

/**
 * @author Quan Yang
 *
 */
public class ProductBuilder implements IProductBuilder {
	private Product product;
	
	public ProductBuilder() {
		product = new Product();
	}

	public void buildProductCategory(ProductCategory category) {
		product.setCategory(category);
	}

	public void buildProductSupplier(ProductSupplier supplier) {
		product.setSupplier(supplier);
	}

	public void buildProductIdName(String id, String name) {
		product.setId(id);
		product.setName(name);
	}

	public void buildPriceAndCount(double unitPrice, int count) {
		product.setUnitPrice(unitPrice);
		product.setTotalCnt(count);
	}

	public void buildDiscount(boolean isDiscount, double discountRatio) {
		product.setDiscount(isDiscount);
		if (isDiscount) {
			product.setDiscountRatio(discountRatio);
		}
	}

	public Product getProduct() {
		return product;
	}

}
