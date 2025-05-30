package Models;

public class BusinessCustomer extends Customer {
    private int cvr;

    public BusinessCustomer(String name, int cvr){
        super(name);
        this.cvr = cvr;
    }

    public int getCvr(){
        return cvr;
    }

    public void setCvr(int cvr){
        this.cvr = cvr;
    }
}
