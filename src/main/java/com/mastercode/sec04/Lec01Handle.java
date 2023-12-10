package com.mastercode.sec04;

import reactor.core.publisher.Flux;

import static com.mastercode.utils.Util.subscriber;

public class Lec01Handle {
    // handle = filter + map

    public static void main(String[] args) {
        Flux.range(1, 20)
                .handle(((integer, synchronousSink) -> {
                    if (integer % 2 == 0) {
                        synchronousSink.next(integer); // filter
                    } else {
                        synchronousSink.next(integer + "m"); // map
                    }
                })).subscribe(subscriber());
    }

}
