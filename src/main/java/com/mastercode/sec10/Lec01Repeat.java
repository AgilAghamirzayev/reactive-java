package com.mastercode.sec10;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

import static com.mastercode.utils.Util.subscriber;

public class Lec01Repeat {

    public static final AtomicInteger atomic = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
                .repeat(1)
                .subscribe(subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("-Completed-"))
                .map(i -> atomic.getAndIncrement());
    }
}
