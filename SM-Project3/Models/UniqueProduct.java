package Models;

public class UniqueProduct extends Product {
    // Inherits all fields from SimpleProduct
    private String serialNumber;

    public UniqueProduct(int productNo, double fixedPrice) {
        super(productNo, 1);  // Unique products always have quantity = 1
        this.serialNumber = serialNumber;
    }

    // Setter for serialNumber
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    // Getter for serialNumber
    public String getSerialNumber() {
        return serialNumber;
    }

    //TODO
    //@Override
    //public double getPrice() {
    //    return serialNumber;
    //}
}
