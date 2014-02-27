package names;

public class Names {
    public static void main(String[] args) {
        //Nameable n = new Nameable();
        
        Person p = new Person();
        p.setName("Bob");
        p.setAddress("617 6th Street");
        
        Organization o = new Organization();
        o.setName("PCS");
        o.setAddress("613 Tora");
        
        System.out.println(p.getName());
        System.out.println(p.getAddress());
        System.out.println(o.getName());
        System.out.println(o.getAddress());
    }
}
