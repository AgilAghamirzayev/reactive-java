package com.mastercode.sec03;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.subscriber;

import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
                    synchronousSink.next(faker().country().name());
                })
                .take(2)
                .subscribe(subscriber());

        Flux.generate(synchronousSink -> {
                    synchronousSink.next(faker().country().name());
                    synchronousSink.complete();
                })
                .take(2)
                .subscribe(subscriber());
    }
}
