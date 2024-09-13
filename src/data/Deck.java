package data;

public enum Deck {
    TWO_DIAMOND(2),
    THREE_DIAMOND(3),
    FOUR_DIAMOND(4),
    FIVE_DIAMOND(5),
    SIX_DIAMOND(6),
    SEVEN_DIAMOND(7),
    EIGHT_DIAMOND(8),
    NINE_DIAMOND(9),
    TEN_DIAMOND(10),
    JACK_DIAMOND(10),
    QUEEN_DIAMOND(10),
    KING_DIAMOND(10),
    ACE_DIAMOND(11),
    TWO_HEARTS(2),
    THREE_HEARTS(3),
    FOUR_HEARTS(4),
    FIVE_HEARTS(5),
    SIX_HEARTS(6),
    SEVEN_HEARTS(7),
    EIGHT_HEARTS(8),
    NINE_HEARTS(9),
    TEN_HEARTS(10),
    JACK_HEARTS(10),
    QUEEN_HEARTS(10),
    KING_HEARTS(10),
    ACE_HEARTS(11),
    TWO_SPADES(2),
    THREE_SPADES(3),
    FOUR_SPADES(4),
    FIVE_SPADES(5),
    SIX_SPADES(6),
    SEVEN_SPADES(7),
    EIGHT_SPADES(8),
    NINE_SPADES(9),
    TEN_SPADES(10),
    JACK_SPADES(10),
    QUEEN_SPADES(10),
    KING_SPADES(10),
    ACE_SPADES(11),
    TWO_CLUBS(2),
    THREE_CLUBS(3),
    FOUR_CLUBS(4),
    FIVE_CLUBS(5),
    SIX_CLUBS(6),
    SEVEN_CLUBS(7),
    EIGHT_CLUBS(8),
    NINE_CLUBS(9),
    TEN_CLUBS(10),
    JACK_CLUBS(10),
    QUEEN_CLUBS(10),
    KING_CLUBS(10),
    ACE_CLUBS(11);


    private final int value;
    private Deck(int value){
        this.value = value;
    };

    public int getValue() {
        return value;
    }
}
