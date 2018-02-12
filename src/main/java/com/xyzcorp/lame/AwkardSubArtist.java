package com.xyzcorp.lame;

import com.xyzcorp.awesome.Artist;

public class AwkardSubArtist extends Artist {
    public void bar() {
        foo();
    }

    public void cool() {
        Artist artist = new Artist();
        artist.foo();
    }
}
