package Models;

/**
 * Write a description of class UniqueProductCopy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

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
