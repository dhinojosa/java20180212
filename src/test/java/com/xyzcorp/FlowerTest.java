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

    @Test
    public void testFlowerBuilderWithPedalsAndLatinName() {
        Flower f = Flower.builder()
                         .latinName("Narcissus")
                         .petals(7)
                         .build();
        assertEquals("Narcissus", f.getLatinName());
        assertEquals(7, f.getPetalCount());
    }

    @Test
    public void testFlowerBuilderWithPedalsAndLatinName2() {
        Flower f = Flower.builder()
                         .petals(7)
                         .latinName("Narcissus")
                         .build();
        assertEquals("Narcissus", f.getLatinName());
        assertEquals(7, f.getPetalCount());
    }
}
