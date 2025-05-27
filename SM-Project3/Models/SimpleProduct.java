package Models;

public class SimpleProduct extends Product {

    public SimpleProduct(int productNo, int quantity, String productName, String manufacturer, String model,
                         double recommendedRetailPrice, String supplierId, String sku) {
        super(productNo, quantity, productName, manufacturer, model, recommendedRetailPrice, supplierId, sku);
    }

    @Override
    public double getPrice() {
        return getQuantity() * getRecommendedRetailPrice();
    }
}
