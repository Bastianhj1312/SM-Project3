package Models;

public class PrivateCustomer extends Customer {
    private int phone;

    public PrivateCustomer(String name, int phone){
        super(name);
        this.phone = phone;
    }

    public int getPhone(){
        return phone;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }
}
