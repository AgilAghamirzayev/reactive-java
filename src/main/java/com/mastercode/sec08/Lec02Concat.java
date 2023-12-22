package com.mastercode.sec08;

import static com.mastercode.utils.Util.subscriber;

import com.mastercode.sec08.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Lec02Concat {
    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d", "e");
        Flux<String> flux3 = Flux.error(new RuntimeException("OOPS"));

//        Flux<String> flux = flux1.concatWith(flux2);
//        flux.subscribe(subscriber());

//        Flux<String> concat = Flux.concat(flux1, flux3, flux2);
        Flux<String> concat = Flux.concatDelayError(flux1, flux3, flux2);
        concat.subscribe(subscriber());
    }
}
