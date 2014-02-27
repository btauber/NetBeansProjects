
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
public class FutureValueApp {

    public static void main(String[] args) {
    System.out.println("\nWelcome to the future Value Calculater");
    
    Scanner scanner = new Scanner(System.in);
    String choice ="y";
     while(choice.equalsIgnoreCase("y")){
         System.out.print("Enter monthely invesment");
         double monthlyInvestment = scanner.nextDouble();
         System.out.print("Enter yearly interst rate");
         double interstRate = scanner.nextDouble();
         System.out.print("Enter number of years");
         int years = scanner.nextInt();
         
         double monthlyInterestRate = interstRate /12/100;
         int months = years * 12;
         double futureValue = calculateFutureValue(monthlyInvestment,monthlyInterestRate,months);
         
         NumberFormat currency = NumberFormat.getCurrencyInstance();
         System.out.println("Future Value:       " + currency.format(futureValue) + "\n");
           
         scanner.nextLine();
         System.out.println("Continue? (y/n) : ");
         
         choice = scanner.nextLine();
         
        
         
     }
    
    }
    private static double calculateFutureValue(double monthlyInvestment,double monthlyInterestRate,int months){
        double futureValue = 0;
        for(int i=0;i< months; i++){
            futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
        }
        return futureValue;
    }
}
