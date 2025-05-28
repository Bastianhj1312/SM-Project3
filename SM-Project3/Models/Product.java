package Models;

public abstract class Product {
    private int productNo;
    private int quantity;
    private String description;
    private String productName;
    private String manufacturer;
    private String model;
    private double recommendedRetailPrice;
    private String supplierId;
    private String sku;
    private double sellingPrice;
    private double costPrice;

    public Product(int productNo, int quantity, String productName, String manufacturer, String model,
                   double recommendedRetailPrice, String supplierId, String sku) {
        this.productNo = productNo;
        this.quantity = quantity;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.model = model;
        this.recommendedRetailPrice = recommendedRetailPrice;
        this.supplierId = supplierId;
        this.sku = sku;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRecommendedRetailPrice() {
        return recommendedRetailPrice;
    }

    public void setRecommendedRetailPrice(double recommendedRetailPrice) {
        this.recommendedRetailPrice = recommendedRetailPrice;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
}
