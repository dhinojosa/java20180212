package com.xyzcorp.futures;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunningCompletableFutures {




    public static void main(String[] args) throws InterruptedException {
        int favoriteNumber = 23;
        CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return favoriteNumber;
                })
                .thenApply(x -> 10 / x)
                .exceptionally(t -> { return -1; })
                .thenAccept(System.out::println);
        System.out.println("Continuing, I'm too busy to wait");
        Thread.sleep(6000);
    }


    public void pseudoCodeOfWhatToExpect() {
        //String json = getFromRequest();

        //CompletableFuture
        //        .supplyAsync(() -> parseJson)
        //        .thenAccept(o -> sendMessageBus);


    }
}
