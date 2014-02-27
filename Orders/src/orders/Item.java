package orders;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
    private String Discribtion = "";
    private int quantity = 0;
    private double price = 0.0;
    private double amount = 0.0;
    private boolean taxable = true;
    
    
    public Item(String Discribtion,int quantity,double price,boolean taxable)
    {
        this.Discribtion = Discribtion;
        this.quantity = quantity;
        this.price = price;
        this.taxable = taxable;
        amount = this.quantity * this.price;
    }
   
    
    public String getDescribtion() {
        return Discribtion;
    }

    
    public int getQuantity() {
        return quantity;
    }

    
    public double getPrice() {
        return price;
    }
    
    public boolean getTaxable()
    {
        return taxable;
    }
    
    public BigDecimal getAmount()
    {
        BigDecimal theAmount = new BigDecimal(amount);
        theAmount = theAmount.setScale(2, RoundingMode.HALF_UP);
        return theAmount;
    }
    
    
}
