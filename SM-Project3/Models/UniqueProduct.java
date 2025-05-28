package Models;

public class UniqueProduct extends Product {
    private String serialNumber;

    public UniqueProduct(int productNo, String serialNumber, double fixedPrice, String productName,
                         String manufacturer, String model, double recommendedRetailPrice,
                         String supplierId, String sku) {
        super(productNo, 1, productName, manufacturer, model, recommendedRetailPrice, supplierId, sku);
        this.serialNumber = serialNumber;
        setSellingPrice(fixedPrice);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
