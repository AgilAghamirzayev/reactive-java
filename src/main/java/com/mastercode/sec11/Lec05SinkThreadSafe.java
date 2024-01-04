package com.mastercode.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

public class Lec05SinkThreadSafe {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();
        flux.subscribe(System.out::println);

        for (int i = 0; i < 1000; i++) {
            int j = i;
            CompletableFuture.runAsync(() -> sink.tryEmitNext(j));
        }
    }
}
