package Models;

public class orderLine {
    private Product product;
    private int quantity;

    public orderLine(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct(){
        return product;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getLineTotal(){
        return product.getSellingPrice() * quantity;  // or product.getSellingPrice() * quantity;
    }
}
