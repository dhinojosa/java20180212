package com.xyzcorp.futures;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListenableFutures {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ListeningExecutorService listeningExecutorService = MoreExecutors
                .listeningDecorator(executorService);

        ListenableFuture<Integer> listenableFuture =
                listeningExecutorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("In Future:" + Thread.currentThread()
                                                        .getName());
                Thread.sleep(600);
                return 400 + 12;
            }
        });

        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("Success! " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Error! " + t.getMessage());
            }
        }, listeningExecutorService);

        Thread.sleep(2000);
        executorService.shutdown();
    }
}
