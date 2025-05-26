package Models;

public class SimpleProduct extends Product {
    private String productName;
    private String manufacturer;
    private String model;
    private double recommendedRetailPrice;
    private int Quantity;
    private String supplierId;
    private String sku;

    public SimpleProduct(int productNo, int quantity, String productName, String manufacturer, String model,
                         double recommendedRetailPrice, String supplierId, String sku) {
        super(productNo, quantity);
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.model = model;
        this.recommendedRetailPrice = recommendedRetailPrice;
        this.supplierId = supplierId;
        this.sku = sku;
    }
    
    // Getter for productName
    public String getProductName() {
        return productName;
    }

    // Setter for productName
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter for manufacturer
    public String getManufacturer() {
        return manufacturer;
    }

    // Setter for manufacturer
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    // Getter for recommendedRetailPrice
    public double getRecommendedRetailPrice() {
        return recommendedRetailPrice;
    }

    // Setter for recommendedRetailPrice
    public void setRecommendedRetailPrice(double recommendedRetailPrice) {
        this.recommendedRetailPrice = recommendedRetailPrice;
    }

    // Getter for stockQuantity
    public int getQuantity() {
        return Quantity;
    }

    // Setter for stockQuantity
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    // Getter for supplierId
    public String getSupplierId() {
        return supplierId;
    }

    // Setter for supplierId
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    // Getter for sku
    public String getSku() {
        return sku;
    }

    // Setter for sku
    public void setSku(String sku) {
        this.sku = sku;
    }

     @Override
    public double getPrice() {
        return getQuantity() * recommendedRetailPrice;
    }
}
