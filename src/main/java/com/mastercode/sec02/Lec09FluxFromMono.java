package com.mastercode.sec02;

import static com.mastercode.utils.Util.onCompleted;
import static com.mastercode.utils.Util.onError;
import static com.mastercode.utils.Util.onNext;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(onNext());

        Flux.range(1, 55)
                .filter(i -> i > 5)
                .next()
                .subscribe(onNext(), onError(), onCompleted());
    }
}
