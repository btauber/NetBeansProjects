package linked;

public class Linked {
    public static void main(String[] args) {
        /*
        LinkedList<String> list = new LinkedList<String>();
       // String hello="hello";
       
        list.add("Goodbye",0);
        list.add("Hello Again");
        list.addLast("In middle");
        list.add("New Begining");
        list.push("the tail");
        System.out.println(list.size());
        //System.out.println(list.remove(0));
        System.out.println(list.get(5));
        System.out.println(list.indexOf("Goodbye"));
        //System.out.println(list.contains(list));
        
        Node[] myArray = list.toArrayNode();
        
        for(int i=0;i<myArray.length;i++){
            System.out.println("the prev is "+myArray[i].getPrev().getData()+" Current "+myArray[i].getData()+ " next is "+myArray[i].getNext().getData());
        }*/
        LinkedList<Person> ll = new LinkedList<>();
        ll.add(new Person("bob",41));
        ll.add(new Person("bob1",40));
        ll.add(new Person("bob2",39));
        ll.add(new Person("bob3",38));
        ll.add(new Person("bob4",37));
        ll.add(new Person("bob5",36));
        ll.add(new Person("bob6",35));
        ll.add(new Person("bob7",34));
        ll.sort();
        Node[] myArray = ll.toArrayNode();
        
        for(int i=0;i<myArray.length;i++){
            System.out.println("the prev is "+myArray[i].getPrev().getData()+" Current "+myArray[i].getData()+ " next is "+myArray[i].getNext().getData());
        }
    }
}
