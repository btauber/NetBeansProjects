package undoredo;

public class HasAddress implements Addressable{
    protected String address;
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
}    