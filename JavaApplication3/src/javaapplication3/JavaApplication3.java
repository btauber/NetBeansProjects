
// importing the Scanner clase.
import java.util.Scanner;
import javax.swing.JTextField;

public class JavaApplication3 {

    
    public static void main(String[] args) {
        
         String ssss = null;
         JTextField ssssh = new JTextField("Enter numbers here", 20);
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter text to check if it is palindrome");
        // inputs the next line into the engine.
        ssss = scanner.nextLine();
        // Replacing the white space.
        ssss = ssss.replaceAll(" " , "");
        // Replacing the Upperecase to Lowercase.
        ssss = ssss.toLowerCase();
        // Reversing the string.
String result = new StringBuffer(ssss).reverse().toString();
        // Checking if its matching.
       if (!result.equals(ssss)){
           System.out.println("no this is not a palindrome");
       }else{
           System.out.println("yes this is a palindrome"); 
       }
            
       // System.out.println(ssss);
    }
    
}
