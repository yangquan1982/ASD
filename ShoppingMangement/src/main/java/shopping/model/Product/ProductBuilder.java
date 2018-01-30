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

	@Override
	public void buildProductCategory(ProductCategory category) {
		product.setCategory(category);
	}

	@Override
	public void buildProductSupplier(ProductSupplier supplier) {
		product.setSupplier(supplier);
	}

	@Override
	public void buildProductIdName(String id, String name) {
		product.setId(id);
		product.setName(name);
	}

	@Override
	public void buildPriceAndCount(double unitPrice, int count) {
		product.setUnitPrice(unitPrice);
		product.setTotalCnt(count);
	}

	@Override
	public void buildDiscount(boolean isDiscount, double discountRatio) {
		product.setDiscount(isDiscount);
		if (isDiscount) {
			product.setDiscountRatio(discountRatio);
		}
	}

	@Override
	public Product getProduct() {
		return product;
	}

}
