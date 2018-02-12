package com.xyzcorp;

public class Flower {


    private final String latinName;

    public Flower(String latinName) {
        this.latinName = latinName;
    }

    public static class FlowerBuilder {
        private String latinName;

        public FlowerBuilder latinName(String latinName) {
            this.latinName = latinName;
            return this;
        }

        public Flower build() {
            return new Flower(latinName);
        }
    }

    public String getLatinName() {
        return latinName;
    }

    public static FlowerBuilder builder() {
        return new FlowerBuilder();
    }
}
