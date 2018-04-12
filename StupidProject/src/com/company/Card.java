package com.company;

import java.util.ArrayList;

/**
 * Created by jburke on 3/22/2018.
 */
public class Card {
    private int value;
    private String suit;
    private String displayValue;
    private ArrayList<String> suitList;

    public Card(int Value, String Suit) {
        suitList = new ArrayList<String>();
        suitList.add("spades");
        suitList.add("hearts");
        suitList.add("clubs");
        suitList.add("diamonds");
        if (Value > 1 && Value < 14) {
            value = Value;
            if (value == 11) {
                displayValue = "J";
            }
            else if (value == 12) {
                displayValue = "Q";
            }
            else if (value == 13) {
                displayValue = "K";
            }
            else if (value == 14) {
                displayValue = "A";
            }
        }
        else {
            value = 0;
        }
        if (suitList.contains(Suit.toLowerCase())) {
            suit = Suit.toLowerCase();
        }
        else {
            suit = null;
        }
    }

    public int GetValue() {
        return value;
    }

    public String GetDisplayValue() {
        return displayValue;
    }

    public String GetSuit() {
        return suit;
    }

    public String GetCardName() {
        return displayValue;
    }
}
