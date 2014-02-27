package tracker;

public class Organization extends Item {
    private String location;
    
    public Organization(String name, String location) {
        super(name);
        this.location = location;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String getDisplayString() {
        String displayString = super.getDisplayString();
        displayString += "\nLocation: " + location;
        return displayString;
    }
    
    public String getExtras()
    {
        return location;
    }
}
