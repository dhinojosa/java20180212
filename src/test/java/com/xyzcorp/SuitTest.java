package com.xyzcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SuitTest {

    @Test
    public void testBasicEnum() {
        Suit suit = Suit.HEARTS;
        assertEquals(Suit.HEARTS,suit);
    }

    @Test
    public void testTrumpSuit() {
        Suit suit = Suit.SPADES;
        assertTrue(suit.isTrumpSuit());
    }

    @Test
    public void testSuitValueOf() {
        Suit suit = Suit.valueOf("HEARTS");
        assertEquals(Suit.HEARTS, suit);
    }

    @Test
    public void testSuitOrdinal() {
        StringBuilder sb = new StringBuilder();
        for (Suit s : Suit.values()) {
            sb.append(s);
            sb.append("[");
            sb.append(s.ordinal());
            sb.append("]\n");
        }
        String s = sb.toString();
        System.out.println(s);
    }

    @Test
    public void testListValues() {
        StringBuilder sb = new StringBuilder();

        for (Suit s : Suit.values()) {
            sb.append(s);
            if (s.isTrumpSuit()) {
                sb.append(" (trump suit)");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
