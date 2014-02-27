package linked;

public class AddPerson {
    public void main (String[] args){
        LinkedList<Person> ll = new LinkedList<>();
        ll.add(new Person("bob",40));
        ll.add(new Person("bob",39));
        ll.add(new Person("bob",38));
        ll.add(new Person("bob",37));
        ll.add(new Person("bob",36));
        ll.add(new Person("bob",35));
        ll.add(new Person("bob",34));
    }
}
