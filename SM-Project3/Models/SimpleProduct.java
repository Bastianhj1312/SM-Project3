package Models;

public class SimpleProduct extends Product {
    private double pricePerUnit;

    public SimpleProduct(int productNo, int quantity, double pricePerUnit) {
        super(productNo, quantity);
        this.pricePerUnit = pricePerUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public double getPrice() {
        return getQuantity() * pricePerUnit;
    }
}
