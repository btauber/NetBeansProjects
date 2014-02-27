
package cards;

public class Card {

    public String suit;
    public String rank;
    
    public Card(String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
    }
    
    public String toString()
    {
        return "I am a "+suit+" and a "+rank;
    }    
    
    
}
