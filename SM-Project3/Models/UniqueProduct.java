package Models;

public class UniqueProduct extends Product {
    private double fixedPrice;

    public UniqueProduct(int productNo, double fixedPrice) {
        super(productNo, 1);  // Unique products always have quantity = 1
        this.fixedPrice = fixedPrice;
    }

    public double getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    @Override
    public double getPrice() {
        return fixedPrice;
    }
}
