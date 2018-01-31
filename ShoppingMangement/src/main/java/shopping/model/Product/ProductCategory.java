/**
 * 
 */
package shopping.model.Product;

/**
 * @author Quan Yang
 *
 */
public class ProductCategory {
	private String id;
	private String categoryName;
	
	public ProductCategory() {
	}
	public ProductCategory(String id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + "]";
	}
	
}
