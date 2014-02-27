package cards;

import java.util.Collections;

public class CardsShuffle {
     public static void main(String[] args) {
        Deck deck = new Deck();
        deck.myDeck();
        Collections.shuffle(deck.CardsObjects);
        
        for(Card myCard:deck.CardsObjects){
            System.out.println(myCard);
        }
            
}
}