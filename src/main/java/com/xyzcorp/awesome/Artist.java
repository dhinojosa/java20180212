package com.xyzcorp.awesome;

public class Artist {

    public void foo() {

    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Artist)) return false;
        Artist artist = (Artist) obj;
        artist.foo();
        return true;
    }
}
