package tracker;

public abstract class Item{
    private String name;
   
    public Item(String name){
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDisplayString() {
        return "My Name is: " + name;
    }
    
    public abstract String getExtras();
}
