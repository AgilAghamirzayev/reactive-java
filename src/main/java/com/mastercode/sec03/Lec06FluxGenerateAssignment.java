package com.mastercode.sec03;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.subscriber;

import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
                    String country = faker().country().name();
                    System.out.println("emitting " + country);
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(subscriber());


    }
}
