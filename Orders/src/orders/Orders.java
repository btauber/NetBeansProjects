package orders;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {
        for (;;) {
            CustomerInput();
        }
    }

    public static void CustomerInput() {
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our POS \n Please enter customer's name");
        String name = scanner.nextLine();
        String more = "y";
        while (more.equalsIgnoreCase("y")) {

            System.out.println(" Please enter the item");
            String Describtion = scanner.nextLine();
            System.out.println("Quantity?");
            int quantity = scanner.nextInt();
            System.out.println("Price?");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Is this a taxable item?");
            String nonTaxable = scanner.nextLine();
            boolean taxable;

            if (nonTaxable.equalsIgnoreCase("yes")) {
                taxable = true;
            } else {
                taxable = false;
            }

            Item item = new Item(Describtion, quantity, price, taxable);
            order.setItem(item);
            System.out.println("More items? y/n ");
            more = scanner.nextLine();
            order.setCustomer(name);
        }

        POS(order);
    }

    public static void POS(Order order) {
        String statmentBody = "";
           
        for (Item item : order.myItems) {
            String itemTaxable = "";

            if (item.getTaxable() == true) {
                itemTaxable = "T";
            } else {
                itemTaxable = "N";
            }
            statmentBody += "" + item.getDescribtion() + " | " + item.getQuantity() + " | "
                    + item.getPrice() + " | " + item.getAmount() + " | " + itemTaxable + "\n";

        }
        BigDecimal _100 = new BigDecimal(100);
        BigDecimal salesTaxPct = order.getSALES_TAX_PCT().divide(_100);
        BigDecimal salesTax = salesTaxPct.multiply(order.getTotalTaxable());
        salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = salesTax.add(order.getTotalAmount());
        total = total.setScale(2, RoundingMode.HALF_UP);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        System.out.println("Welcome for shopping by us \n Customer " + order.getCustomer()
                + "\n" + statmentBody
                + "Total items:            " + order.getItemCount()
                + "\nTotal taxable:          " + currency.format(order.getTotalTaxable())
                + "\nTotal non taxable:      " + currency.format(order.getTotalNonTaxable())
                + "\nTax percent:             " + order.getSALES_TAX_PCT().doubleValue()
                + "%\nTotal Amount before tax:" + currency.format(order.getTotalAmount())
                + "\nTotal tax Amount:       " + currency.format(salesTax)
                + "\nTotal Amount after tax: " + currency.format(total));

    }
}
