package com.xyzcorp;

public class OuterClass {

    private int a = 10;
    private static int z = 30;

    public class InnerClass {
        private int b = 20;

        public int foo() {
            return a + b;
        }
    }

    public static class StaticInnerClass {
        private int c = 40;
        public int bar() {return c + z;}
    }

    public static int myStatic() {
        StaticInnerClass sic = new StaticInnerClass();
        return sic.bar() + 44;
    }
}
