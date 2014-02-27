package orders;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order{
    private BigDecimal SALES_TAX_PCT = new BigDecimal(7.0);
    protected ArrayList<Item> myItems = new ArrayList<Item>();
    private String customer = "";
    private double previousBalance = 0.00;
    private int itemCount = 0;
    private BigDecimal totalTaxable = new BigDecimal(0.0);
    private BigDecimal totalNonTaxable = new BigDecimal(0.0);
    private BigDecimal totalAmount = new BigDecimal(0.0);
    
    public void setItem(Item item)
    {
        myItems.add(item);
        if(item.getTaxable()==true){
            totalTaxable = totalTaxable.add(item.getAmount()); 
            totalAmount = totalAmount.add(item.getAmount());
        }else{    
            totalNonTaxable = totalNonTaxable.add(item.getAmount());
            totalAmount = totalAmount.add(item.getAmount());
        }   
        itemCount ++;
        
    }
    
    public void removeItem()
    {
        itemCount--;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalTaxable() {
        return totalTaxable;
    }

    public BigDecimal getTotalNonTaxable() {
        return totalNonTaxable;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getSALES_TAX_PCT() {
        
        return SALES_TAX_PCT;
    }

    public int getItemCount() {
        return itemCount;
    }
    
    
    
}
