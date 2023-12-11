package com.mastercode.sec04;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static com.mastercode.utils.Util.*;

public class Lec06OnError {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(integer -> 10 / (5 - integer))
//                .onErrorReturn(-1)
//                .onErrorResume(e -> fallback())
                .onErrorContinue((err, obj) -> {})
                .subscribe(subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> faker().random().nextInt(10, 20));
    }
}
