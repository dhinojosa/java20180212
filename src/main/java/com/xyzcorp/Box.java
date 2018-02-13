package com.xyzcorp;

import java.util.Objects;
import java.util.function.Function;

public class Box<T> {

    private T t;

    public Box(T t) {
        this.t = t;
    }

    public T getItem() {
        return t;
    }

    public <U> Box<U> map(Function<? super T, ? extends U> function) {
        return new Box<>(function.apply(t));
    }

    public <U> Box<U> flatMap(Function<? super T, ? extends Box<U>> function) {
        return function.apply(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Objects.equals(t, box.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t);
    }
}
