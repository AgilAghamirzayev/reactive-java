package com.mastercode.sec2;

import reactor.core.publisher.Flux;

import static com.mastercode.utils.Util.onCompleted;
import static com.mastercode.utils.Util.onError;
import static com.mastercode.utils.Util.onNext;

public class Lec01FluxInfo {
    public static void main(String[] args) {
        Flux<Integer> flux1 = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> flux2 = Flux.empty();
        Flux<Integer> flux3 = Flux.error(new RuntimeException("Something went wrong"));


        flux1.subscribe(onNext(), onError(), onCompleted());
        flux2.subscribe(onNext(), onError(), onCompleted());
        flux3.subscribe(onNext(), onError(), onCompleted());
    }
}
