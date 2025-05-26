package Models;

public class UniqueProduct extends Product {
    private String serialNumber;

    public UniqueProduct(int productNo, String serialNumber, double fixedPrice) {
        super(productNo, 1);  // Unique products always have quantity = 1
        this.serialNumber = serialNumber;
        setSellingPrice(fixedPrice);
    }

    @Override
    public double getPrice() {
        return getSellingPrice();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
