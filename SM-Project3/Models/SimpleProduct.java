package Models;

public class SimpleProduct extends Product {
    private String category;

    public SimpleProduct(int productNo, int quantity, String productName, String manufacturer, String model,
                         double recommendedRetailPrice, String supplierId, String sku, String category) {
        super(productNo, quantity, productName, manufacturer, model, recommendedRetailPrice, supplierId, sku);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
