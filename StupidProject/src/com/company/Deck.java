package com.company;

import java.util.ArrayList;

import java.util.List;

import java.util.Random;

/**
 * Created by jburke on 3/26/2018.
 */
public class Deck {
    private ArrayList<Card> remainingCards;
    private ArrayList<Card> discardPile;
    Random rand;

    public Deck() {
        rand = new Random();
        remainingCards = new ArrayList<>();
        discardPile = new ArrayList<>();
        InitializeDeck();
    }

    public int GetNumCardsDeck() { return remainingCards.size(); }

    public int GetNumCardsTotal() { return remainingCards.size() + discardPile.size(); }

    public Card DrawCard() {*
        Card topCard = new Card(0, "null");
        if (remainingCards.size() != 0) {
            topCard = remainingCards.get(0);
            remainingCards.remove(0);
        }
        else if (discardPile.size() != 0) {
            ShuffleAll();
        }
        return topCard;
    }

    public void DiscardCard(Card card) { discardPile.add(card); }

    public void AddCardToDeck(Card card) {
        remainingCards.add(card);
    }

    public void ShuffleRemaining() {
        int shuffleNumber = remainingCards.size();
        while (shuffleNumber > 1) {
            int randNum = rand.nextInt(remainingCards.size() - 1);
            shuffleNumber--;
            Card shuffledCard = remainingCards.get(randNum);
            remainingCards.set(randNum, remainingCards.get(shuffleNumber));
            remainingCards.set(shuffleNumber, shuffledCard);
        }
    }

    public void ShuffleAll() {
        for (int i = 0; i < discardPile.size(); i++) {
            remainingCards.add(discardPile.get(i));
        }
        discardPile.clear();
        ShuffleRemaining();
    }

    public void ResetAndShuffle() {
        ClearDeck();
        InitializeDeck();
        ShuffleRemaining();
    }

    public void ClearDeck() {
        remainingCards.clear();
        discardPile.clear();
    }

    private void InitializeDeck() {
        String[] suitArray = new String[] {"spades", "hearts", "clubs", "diamonds"};
        for (int suitCount = 0; suitCount < 4; suitCount++) {
            for (int value = 2; value < 15; value++) {
                remainingCards.add(new Card(value, suitArray[suitCount]));
            }
        }
    }
}