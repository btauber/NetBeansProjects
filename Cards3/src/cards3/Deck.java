package cards3;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    public Deck() {
        for(Card.Suit suit : Card.Suit.values()) {
            for(Card.Value value : Card.Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public String toString() {
        String retVal = "";
        for(Card card : cards) {
            retVal += card;
            retVal += "\n";
        }
        return retVal;
    }
}
