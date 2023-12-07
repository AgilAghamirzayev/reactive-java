package com.mastercode.sec03;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.subscriber;

import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    String country;

                    do {
                        country = faker().country().name();
                        System.out.println("emitting : " + country);
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());

                    fluxSink.complete();
                })
                .take(3)
                .subscribe(subscriber());
    }
}
