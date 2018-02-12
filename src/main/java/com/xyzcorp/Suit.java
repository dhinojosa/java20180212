package com.xyzcorp;

public enum Suit {
    HEARTS, CLUBS, SPADES(true), DIAMONDS;

    private boolean isTrumpSuit;

    Suit() {
       isTrumpSuit = false;
    }

    Suit(boolean trumpSuit) {
       isTrumpSuit = trumpSuit;
    }

    public boolean isTrumpSuit() {
        return isTrumpSuit;
    }
}
