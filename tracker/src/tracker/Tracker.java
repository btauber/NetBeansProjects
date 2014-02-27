
package tracker;

import java.util.ArrayList;

public class Tracker {
    public static void main(String[] args) {
        //Person person = new Person("Bob", 27);
        //Organization organization = new Organization("PCS", "Lakewood, NJ");
        
        //System.out.println(person.getName());
        //System.out.println(organization.getName());
        
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Person("Bob", 27));
        items.add(new Organization("PCS", "Lakewood, NJ"));
        //items.add(new Item("I am an Item"));
        
        for(Item item : items) {
            //System.out.println(item.getName());
            System.out.println(item.getDisplayString());
            System.out.println(item.getExtras());
            
            // Dont do this - but it can be done
            if (item instanceof Person ) {
                Person person = (Person)item;
                System.out.println(person.getAge());
            }
        }
    }
}
