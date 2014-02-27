package cards3;

public class Card {

    public enum Value {

        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING;

        public String toString() {
            String retVal = "";
            switch (this) {
                case ACE:
                    retVal = "Ace";
                    String hgh = "ghj";
                    break;
                case TWO:
                    retVal = "Two";
                    break;
                case THREE:
                    retVal = "Three";
                    break;
                case FOUR:
                    retVal = "Four";
                    break;
                case FIVE:
                    retVal = "Five";
                    break;
                case SIX:
                    retVal = "Six";
                    break;
                case SEVEN:
                    retVal = "Seven";
                    break;
                case EIGHT:
                    retVal = "Eight";
                    break;
                case NINE:
                    retVal = "Nine";
                    break;
                case TEN:
                    retVal = "Ten";
                    break;
                case JACK:
                    retVal = "Jack";
                    break;
                case QUEEN:
                    retVal = "Queen";
                    break;
                case KING:
                    retVal = "King";
                    break;

            }
            return retVal;
        }

    }

    public enum Suit {

        HEARTS,
        CLUBS,
        SPADES,
        DIAMONDS;

        public String toString() {
            String retVal = "";
            switch (this) {
                case HEARTS:
                    retVal += "Hearts";
                    break;
                case SPADES:
                    retVal += "Spades";
                    break;
                case DIAMONDS:
                    retVal += "Diamonds";
                    break;
                case CLUBS:
                    retVal += "Clubs";
                    break;
            }
            return retVal;
        }

    }

    private Value value;
    private Suit suit;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        String retVal = value.toString();
        retVal+=" of";
        retVal += suit.toString();
        return retVal;
    }

    
}
