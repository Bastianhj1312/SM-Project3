package Models;

public class UniqueProductCopy {
    private UniqueProduct product;
    private int serialNumber;

    public UniqueProductCopy(UniqueProduct product, int serialNumber) {
        this.product = product;
        this.serialNumber = serialNumber;
    }

    public UniqueProduct getProduct() {
        return product;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
