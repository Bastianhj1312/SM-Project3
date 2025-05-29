package Models;

public class UniqueProduct extends Product {

    public UniqueProduct(int productNo, double sellingPrice, String productName,
    String manufacturer, String model, double recommendedRetailPrice,
    String supplierId, String sku) {
        super(productNo, 1, productName, manufacturer, model, recommendedRetailPrice, supplierId, sku);
        setSellingPrice(sellingPrice);
    }

    public boolean isUniqueProduct() {
        return true;
    }
}
