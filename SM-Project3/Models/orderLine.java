package Models;

public class orderLine {
    private Product product;
    private UniqueProductCopy uniqueCopy;
    private int quantity;

    // Constructor for regular products
    public orderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // konstruktor til uniqueproducts hvor antal altid er 1
    public orderLine(UniqueProductCopy uniqueCopy) {
        this.uniqueCopy = uniqueCopy;
        this.product = uniqueCopy.getProduct(); 
        this.quantity = 1;
    }

    public Product getProduct() {
        return product;
    }

    public UniqueProductCopy getUniqueProductCopy() {
        return uniqueCopy;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getLineTotal() {
        return product.getSellingPrice() * quantity;
    }

    public boolean isUnique() {
        return uniqueCopy != null;
    }
}
