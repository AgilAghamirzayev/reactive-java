package com.mastercode.sec2;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.onNext;

import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> faker().name().fullName())
                .subscribe(onNext());

        Flux.range(1, 10).subscribe(s -> System.out.println("Test " + s));
    }
}
