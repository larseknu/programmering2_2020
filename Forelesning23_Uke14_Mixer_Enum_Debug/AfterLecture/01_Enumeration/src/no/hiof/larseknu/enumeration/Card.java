package no.hiof.larseknu.enumeration;

public class Card {
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    private CardValue value;
    private Suit suit;

    public Card(Suit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return value.name() + " of " + suit;
    }
}
