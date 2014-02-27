

import java.util.GregorianCalendar;

 public class Star {

    public static void main(String[] args) {
      myMethod(78);
}
    
    public  static void myMethod(int counter)
    {
        if(counter == 0)
            return;
        else{
            System.out.println(counter);
            myMethod(--counter);
            return;
        }
                    
    }
   
 }
