package tracker;

public class Person extends Item {
    private int age;
    
    public Person(String name, int age) {
        super(name);
        this.age = age;
    }
    
    public int getAge()
    {
        return age;
    }
    
    @Override
    public String getDisplayString() {
        String displayString = super.getDisplayString();
        displayString += "\nAge: " + age;
        return displayString;
    }
    
    public String getExtras()
    {
        return "" + age;
    }
}
