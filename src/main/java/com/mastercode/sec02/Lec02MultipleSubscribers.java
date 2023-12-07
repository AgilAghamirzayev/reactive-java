package com.mastercode.sec02;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> flux1 = Flux.just(1, 2, 3, 4);

        flux1.subscribe(i -> System.out.println("Sub 1: " + i));
        flux1.subscribe(i -> System.out.println("Sub 2: " + i));
    }
}
