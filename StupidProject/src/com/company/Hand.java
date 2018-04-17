package com.company;

import java.util.ArrayList;

/**
 * Created by jburke on 3/26/2018.
 */
public class Hand {
    private ArrayList<Card> playerCards;

    public Hand {
        playerCards = new ArrayList<>();
    }

    public void AddCardToHand(Card card) {
        playerCards.add(card);
    }

    public ArrayList<Card> GetCards() {
        return playerCards;
    }
}
