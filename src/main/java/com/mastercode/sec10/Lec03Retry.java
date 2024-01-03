package com.mastercode.sec10;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

import static com.mastercode.utils.Util.subscriber;

public class Lec03Retry {

    public static final AtomicInteger atomic = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
                .retry(2)
                .subscribe(subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("-Completed-"))
                .map(i ->  i/ 0)
                .doOnError(err -> System.out.println("--error"));
    }

}
