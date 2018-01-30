/**
 * 
 */
package shopping.model.Product;

/**
 * @author Quan Yang
 *
 */
public class Product {
	private String id;
	private String name;
	private ProductCategory category;
	private double unitPrice;
	private int totalCnt;
	private ProductSupplier supplier;
	private boolean isDiscount;
	private double discountRatio;
	
	public double getDiscountRatio() {
		return discountRatio;
	}
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public ProductSupplier getSupplier() {
		return supplier;
	}
	public void setSupplier(ProductSupplier supplier) {
		this.supplier = supplier;
	}
	public boolean isDiscount() {
		return isDiscount;
	}
	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}
}
