/**
 * 
 */
package shopping.dto;

/**
 * @author Quan Yang
 *
 */
public class ProductDTO {
	private String id;
	private String productName;
	private String productCategoryId;
	private String productSupplierId;
	private double unitPrice;
	private int totalCnt;
	private boolean isDiscount;
	private double discountRatio;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductSupplierId() {
		return productSupplierId;
	}
	public void setProductSupplierId(String productSupplierId) {
		this.productSupplierId = productSupplierId;
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
	public boolean isDiscount() {
		return isDiscount;
	}
	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}
	public double getDiscountRatio() {
		return discountRatio;
	}
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
}
