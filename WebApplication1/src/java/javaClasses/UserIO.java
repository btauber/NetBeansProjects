package javaClasses;

import java.io.*;

public class UserIO {
    
    public static void add(User user,String fileName) throws IOException{
        PrintWriter out = new PrintWriter(
                          new BufferedWriter(
                          new FileWriter(fileName)));
        out.println(user.getFirstName()+"|"
                +user.getLastName()+"|"
                +user.getEmailAddress());
        out.close();
        
    }
}
