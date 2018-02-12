package com.xyzcorp;

public class Flower {

    private final String latinName;
    private final int petalCount;
    private final String color;

    public static class FlowerBuilder {
        private String latinName;
        private int petalCount = 0;
        private String color;

        public FlowerBuilder latinName(String latinName) {
            this.latinName = latinName;
            return this;
        }

        public Flower build() {
            return new Flower(latinName, petalCount, color);
        }

        public FlowerBuilder petals(int i) {
            this.petalCount = i;
            return this;
        }

        public FlowerBuilder color(String color) {
            this.color = color;
            return this;
        }
    }

    private Flower(String latinName, int petalCount, String color) {
        this.latinName = latinName;
        this.petalCount = petalCount;
        this.color = color;
    }

    public int getPetalCount() {
        return this.petalCount;
    }

    public String getLatinName() {
        return latinName;
    }

    public String getColor() {
        return color;
    }

    public static FlowerBuilder builder() {
        return new FlowerBuilder();
    }
}
