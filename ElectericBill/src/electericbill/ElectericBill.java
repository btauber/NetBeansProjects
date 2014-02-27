package electericbill;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ElectericBill {

    public static void main(String[] args) {
        theCalculater();
    }
    
    public static void theCalculater()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the bill calculater \n whats the balance of the bill?");
        BigDecimal decMonthleyBill = new BigDecimal(Double.toString(scanner.nextDouble()));
        System.out.println("kwy from the bill?");
        BigDecimal decimalKwyBill = new BigDecimal(Integer.toString(scanner.nextInt()));
        System.out.println("kwy from Weiss");
        BigDecimal decKwyWeiss = new BigDecimal(Integer.toString(scanner.nextInt()));
        
        BigDecimal eachKwy = decMonthleyBill.divide(decimalKwyBill,2,RoundingMode.HALF_UP);
        
        //double eachKwy = monthlyBill/(double)kwyBill;
        BigDecimal weissShare = eachKwy.multiply(decKwyWeiss);
        //double weissShare = eachKwy * (double)kwyWeiss;
        System.out.println("weiss share is "+weissShare);
    }
}
