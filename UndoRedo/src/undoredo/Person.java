package undoredo;

public class Person implements NameOrAddObj{
    private HasName myName = new HasName();
    private HasAddress myAddress = new HasAddress();
    private String type = "person";
    
    public void setName(String name) {
        myName.setName(name);
    }
    
    public String getName() {
        return myName.getName();
    }
    
    public void setAddress(String address) {
        myAddress.setAddress(address);
    }
    
    public String getAddress() {
        return myAddress.getAddress();
    }
    
    public String getType()
    {
        return type;
    }
}
