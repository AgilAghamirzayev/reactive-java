package com.mastercode.sec04;

import reactor.core.publisher.Flux;

import static com.mastercode.utils.Util.subscriber;

public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 99)
                .subscribe(subscriber());
    }

}
