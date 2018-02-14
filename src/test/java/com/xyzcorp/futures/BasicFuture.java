package com.xyzcorp.futures;

import java.util.concurrent.*;

public class BasicFuture {
    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(
                new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("In Future:" + Thread.currentThread()
                                                      .getName());
                Thread.sleep(600);
                return 400 + 12;
            }
        });

        System.out.println("In Main 1: " + Thread.currentThread().getName());
        while (!future.isDone()) {
            System.out.println("Doing something else in Thread: " + Thread
                    .currentThread().getName());
        }
        Integer integer = future.get();
        System.out.println("I got an answer and it is " + integer);
        System.out.println("In Main 2: " + Thread.currentThread().getName());
    }
}
