package com.xyzcorp;

public class Flower {


    private final String latinName;
    private final int petalCount;

    public Flower(String latinName) {
        this.latinName = latinName;
        this.petalCount = 0;
    }

    public Flower(String latinName, int petalCount) {
        this.latinName = latinName;
        this.petalCount = petalCount;
    }

    public int getPetalCount() {
        return this.petalCount;
    }

    public static class FlowerBuilder {
        private String latinName;
        private int petalCount = 0;

        public FlowerBuilder latinName(String latinName) {
            this.latinName = latinName;
            return this;
        }

        public Flower build() {
            return new Flower(latinName, petalCount);
        }

        public FlowerBuilder petals(int i) {
            this.petalCount = i;
            return this;
        }
    }

    public String getLatinName() {
        return latinName;
    }

    public static FlowerBuilder builder() {
        return new FlowerBuilder();
    }
}
