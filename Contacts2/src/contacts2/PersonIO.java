package contacts2;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonIO {
    
    public static void add(Person person,String fileName) throws IOException{
        PrintWriter out = new PrintWriter(
                          new BufferedWriter(
                          new FileWriter(fileName,true)));
        out.println(person.getName()+"|"
                +person.getAdd()+"|"
                +person.getPhone()+"|"
                +person.getEmailAdd());
        out.close();
        
    }
    
    public static void writeObj(ArrayList array){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                                     new BufferedOutputStream(
                                     new FileOutputStream("ArrayList")));
            oos.writeObject(array);
            oos.close();
        } catch (FileNotFoundException  ex) {
            System.err.println(ex);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        
    }
    
    public static ArrayList readObj() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                                    new BufferedInputStream(
                                    new FileInputStream("ArrayList")));
            ArrayList list =(ArrayList)ois.readObject();
            ois.close();
            return list;
        } catch (FileNotFoundException ex) {
            System.err.println("1");
            } catch (IOException ex) {
                System.err.println("2");
            } catch (ClassNotFoundException ex) {
                System.err.println("3");
            }
        return null;
    }
}
