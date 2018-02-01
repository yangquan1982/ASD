/**
 * 
 */
package shopping.dto;

/**
 * @author Quan Yang
 *
 */
public class ProductCategoryDTO {
	private String id;
	private String categoryName;
	
	public ProductCategoryDTO() {
	}
	public ProductCategoryDTO(String id, String categoryName) {
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
}
