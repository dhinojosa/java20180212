package com.xyzcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OuterClassTest {

    @Test
    public void testAdd() {
        assertEquals(3, 4 - 1);
    }
    @Test
    public void testInnerClass() {
        OuterClass.InnerClass oi = new OuterClass().new InnerClass();
        assertEquals(30, oi.foo());
    }

    @Test
    public void testInstantiateOuterFirst() {
       OuterClass outerClass = new OuterClass();
       OuterClass.InnerClass oi = outerClass.new InnerClass();
    }

    @Test
    public void testStaticInnerClass() {
        OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
        assertEquals(60, sic.bar());
    }


}
