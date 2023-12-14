package com.mastercode.sec06;

import static com.mastercode.utils.Util.sleep;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOn {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("next " + i));

         flux
                .doFirst(() -> printThreadName("first2 "))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("first1 "))
                .subscribe(v -> printThreadName("sub " + v));

        sleep(60);
    }

    private static void printThreadName(String message) {
        System.out.println(message + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
