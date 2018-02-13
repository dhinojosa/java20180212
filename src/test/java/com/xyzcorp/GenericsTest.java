package com.xyzcorp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsTest {


    @Test
    public void testAssignment() {
        Generics generics = new Generics();
        generics.foo(new BucsFan());
    }

    @Test
    public void testGetFromListWithBucsFans() {
        List<BucsFan> bucsFans = Arrays.asList(
            new BucsFan(),
            new BucsFan(),
            new BucsFan()
        );

        Generics generics = new Generics();
        generics.getFromList(bucsFans);
    }

    @Test
    public void testGetFromListWithNewYorkers() {
        List<NewYorker> newYorkers = Arrays.asList(
            new NewYorker(),
            new NewYorker(),
            new NewYorker()
        );

        Generics generics = new Generics();
        generics.getFromList(newYorkers);
    }

    @Test
    public void testAddToListWithNewYorkers() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human());
        humans.add(new Human());
        Generics generics = new Generics();
        generics.addToList(humans);
    }
}
