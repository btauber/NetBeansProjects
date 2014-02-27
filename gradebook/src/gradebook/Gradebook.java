package gradebook;

import java.util.Random;
import java.util.Scanner;

public class Gradebook {

    public static void main(String[] args) 
    {
        
            // System.out.println("Student's name");
            Scanner scanner = new Scanner(System.in);
      
            // System.out.println("Student's grade");
        Student givenName = new Student(scanner.nextLine());
       for(;;){
            int grade = scanner.nextInt();
            
            givenName.addGrade(grade);
           
            
        System.out.println(givenName.getName() + ": " + givenName.getAverage());
        
            }
    } 
}
