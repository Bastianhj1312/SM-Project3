package Models;

public abstract class Product {
    private int productNo;
    private int quantity;
    private String description;
    private String category;
    private double sellingPrice;
    private double costPrice;

    public Product(int productNo, int quantity){
        this.productNo = productNo;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }

    public int getProductNo(){
        return productNo;
    }

    public void setProductNo(int productNo){
        this.productNo = productNo;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter for sellingPrice
    public double getSellingPrice() {
        return sellingPrice;
    }

    // Setter for sellingPrice
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    // Getter for costPrice
    public double getCostPrice() {
        return costPrice;
    }

    // Setter for costPrice
    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    // You can force subclasses to define this
    public abstract double getPrice();
}
