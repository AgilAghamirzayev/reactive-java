package com.mastercode.sec04;

import reactor.core.publisher.Flux;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.subscriber;

public class Lec02HandleAssignment {
    // handle = filter + map

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(faker().country().name()))
                .map(Object::toString)
                .handle(((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })).subscribe(subscriber());
    }

}
