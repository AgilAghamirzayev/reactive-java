package com.mastercode.sec03;

import static com.mastercode.utils.Util.subscriber;

import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(subscriber());

    }
}
