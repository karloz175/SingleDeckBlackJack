package logic;

import data.Deck;

import java.util.Random;

public class BlackjackGame {
    private static final int CARDS_TO_PLAY = 52;

    private Deck[] deckToPlay = new Deck[CARDS_TO_PLAY];

    public BlackjackGame() {
    }

    public Deck[] newshuffledDeck(){
        int i = 0;
        for(Deck deck : Deck.values()){
            deckToPlay[i] = deck;
            i++;
        }
        return shuffleDeck(deckToPlay);
    }

    public Deck[] shuffleDeck(Deck[] deck){
        Random rand = new Random();

        for (int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length);
            Deck temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }

        return deck;
    }
}
