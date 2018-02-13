package com.xyzcorp;

import java.util.List;

public class Generics {

    public void foo(American american) { }

    // (E)xtends can g(E)t
    // covariance
    public void getFromList(List<? extends American> americanList) {
        American american = americanList.get(0);
        System.out.println("Murica!" + american);

        //Polymorphism still works
        Object object = americanList.get(0);
        Human human = americanList.get(0);
        NorthAmerican northAmerican = americanList.get(0);
    }

    // S(u)per can p(u)t
    // contravariance
    public void addToList(List<? super American> americanOrHigherList) {
        //americanOrHigherList.set(0, new Object());
        //americanOrHigherList.set(1, new Human());
        //americanOrHigherList.set(2, new NorthAmerican());
        americanOrHigherList.add(new American());
        americanOrHigherList.add(new NewYorker());
        americanOrHigherList.add(new NewMexican());
        americanOrHigherList.add(new BucsFan());
        americanOrHigherList.add(new JagsFans());
        americanOrHigherList.add(new DolphinsFan());

        //American american = americanOrHigherList.get(4);


    }
}
