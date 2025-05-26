package Models;

public class Product {
    private int productNo;
    private int quantity;
    
    public Product(int productNo, int quantity){
        this.productNo = productNo;
        this.quantity = quantity;
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

}
