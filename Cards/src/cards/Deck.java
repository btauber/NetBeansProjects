package cards;

import java.util.ArrayList;

public class Deck {
    public String[] suit ={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    public String[] rank ={"clubs","diamonds","hearts","spades"};
    public  ArrayList <Card> CardsObjects = new ArrayList<Card>();
    
    public void myDeck()
    {
        for(String eachSuit: suit){
            for(String eachRank: rank){
                Card card = new Card(eachSuit,eachRank);
                CardsObjects.add(card);
            }
        }
        
        
        
    }
    
}
