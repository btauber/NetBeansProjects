package contacts2;

import java.io.Serializable;


 
public class Person implements Serializable,Comparable{
   
    private String name;
    private String add;
    private String phone;
    private String emailAdd;

    public Person(String name,String add,String phone,String emailAdd){
        this.name = name;
        this.add = add;
        this.phone = phone;
        this.emailAdd = emailAdd;
        
    }
    
    public String getName() {
        return name;
    }

    public String getAdd() {
        return add;
    }

    
    public String getPhone() {
        return phone;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public void setAdd(String add) {
        this.add = add;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }
    public int compareTo(Object pr){
        Person p =(Person)pr;
        return this.name.compareTo(p.name);
    }

    
}
