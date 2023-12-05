package com.mastercode.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);
        System.out.println("getName().START: thread:" + Thread.currentThread().getName());

        mono.subscribe(integer -> {
            System.out.println(integer);
            System.out.println("getName().START: thread:" + Thread.currentThread().getName());
        });
        mono.subscribe(System.out::println);
    }
}
