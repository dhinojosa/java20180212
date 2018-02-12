package com.xyzcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlowerTest {

    @Test
    public void testFlowerBuilder() {
        Flower f = Flower.builder()
                         .latinName("Narcissus")
                         .build();
        assertEquals("Narcissus", f.getLatinName());
    }
}
