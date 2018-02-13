package com.xyzcorp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class BoxTest {
    @Test
    public void testBoxInteger() {
        Box<Integer> box = new Box<>(30);
        Integer i = box.getItem();
        assertThat(i).isEqualTo(30);
    }

    @Test
    public void testBoxString() {
        Box<String> box = new Box<>("Foo");
        String s = box.getItem();
        assertThat(s).isEqualTo("Foo");
    }

    @Test
    public void testStreamWithMapForAnExample() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stringStream = integerStream
            .map(integer -> "Foo" + integer);
        List<String> collect = stringStream
            .collect(Collectors.toList());
        assertThat(collect).contains("Foo1", "Foo2");
    }

    @Test
    public void testBoxWithMap() {
        Box<Integer> integerBox = new Box<>(3);
        Box<String> stringBox = integerBox
            .map(integer -> "Foo" + integer);
        assertThat(stringBox.getItem()).isEqualTo("Foo3");
    }

    @Test
    public void testBoxWithMapAlternate() {
        Box<Integer> integerBox = new Box<>(3);
        Box<String> stringBox = integerBox
            .map(integer -> "FooBarBaz" + integer);
        assertThat(stringBox.getItem()).isEqualTo("FooBarBaz3");
    }

    @Test
    public void testBoxWithMapAlternateInteger() {
        Box<Integer> integerBox = new Box<>(3);
        Box<Integer> stringBox = integerBox
            .map(integer -> integer * 3);
        assertThat(stringBox.getItem()).isEqualTo(9);
    }

    @Test
    public void testFlatMapWithStreams() {
        Stream<Stream<Integer>> g = Stream.of(1, 2, 3, 4)
                                          .map(x -> Stream.of(-x, x, x + 1));

        Stream<Integer> h = Stream.of(1, 2, 3, 4)
                                  .flatMap(x -> Stream.of(-x, x, x + 1));

    }

    @Test
    public void testFlatMap() {
        Box<Integer> integerBox = new Box<>(3);
        Box<Integer> result = integerBox.flatMap(i -> new Box<>(i + 3));
        assertThat(result).isEqualTo(new Box<>(6));
    }

    @Test
    public void testPinkFloydLyrics() {
        List<String> lyrics = Arrays.asList(
            "So, so you think you can tell",
            "Heaven from hell",
            "Blue skies from pain",
            "Can you tell a green field",
            "from a cold steel rail?"
        );


//        Map<String, List<String>> before = wordStream.collect(Collectors
//            .groupingBy(new Function<String, String>
//            () {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        }));
//
//        System.out.println(before);
//
        Map<String, Long> after = lyrics
            .stream()
            .flatMap(s -> Stream.of(s.split(" ")))
            .collect(Collectors
                .groupingBy(o -> o, Collectors.counting()));

        System.out.println(after);
    }
}
