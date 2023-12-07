package com.mastercode.sec03;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.subscriber;

import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {

//        Flux.create(fluxSink -> {
//          fluxSink.next(1);
//          fluxSink.next(2);
//          fluxSink.complete();
//        }).subscribe(subscriber());

        Flux.create(fluxSink -> {
            String country;

            do {
                country = faker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada"));

            fluxSink.complete();
        }).subscribe(subscriber());

    }
}
