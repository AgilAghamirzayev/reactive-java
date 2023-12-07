package com.mastercode.sec03;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.subscriber;

import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {

        Flux.generate(
                        () -> 1,
                        (counter, sink) -> {
                            String country = faker().country().name();
                            sink.next(country);
                            if (country.equalsIgnoreCase("canada") || counter >= 10) {
                                sink.complete();
                            }
                            return counter + 1;
                        })
                .take(4)
                .subscribe(subscriber());


    }
}
