package com.mastercode.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(System.out::println);
        mono.subscribe(System.out::println);
    }
}
