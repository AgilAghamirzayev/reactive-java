package com.mastercode.sec01;

import reactor.core.publisher.Mono;

import static com.mastercode.utils.Util.onCompleted;
import static com.mastercode.utils.Util.onError;
import static com.mastercode.utils.Util.onNext;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("Ali")
                .map(String::length)
                .map(l -> l / 0);

        mono.subscribe(onNext(), onError(), onCompleted());
    }
}
