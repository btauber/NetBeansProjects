package linked;

public class Person implements MyComparable<Person>{
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    public int compareTo(Person p) {
        if (this == p) {
            return 0;
        }
        
        if (p == null) {
            return 1;
        }

        if (this.age < p.getAge()) {
            return -1;
        }
        
        if (this.age == p.getAge()) {
            return 0;
        }
        
        //if (this.age > p.getAge()) {
        return 1;
        //}
    }
    
    public String toString()
    {
      return name+" "+age;  
    }
}
