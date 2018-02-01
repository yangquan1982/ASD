package shopping.model.ShoppingCart;

import shopping.model.Product.Product;

/**
 * Created by Duong Truong on 1/30/2018.
 */
public class LineItem {
    public LineItem(Product product) {
        setProduct(product);
        setQuantity(1);
        setProductName(product.getName());
        setLineItemId(product.getId());
        setUnitCost(product.getUnitPrice());
        setSubtotal(product.getUnitPrice());
    }

    public LineItem(String lineItemId, String productName, int quantity, double unitCost, double subtotal) {
        setLineItemId(lineItemId);
        setProductName(productName);
        setQuantity(quantity);
        setUnitCost(unitCost);
        setSubtotal(subtotal);
    }

    private Product product;

    private String lineItemId;

    private String productName;

    private int quantity;

    private double unitCost;

    private double subtotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
