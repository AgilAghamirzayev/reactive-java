package com.mastercode.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static com.mastercode.utils.Util.sleep;

public class Lec07SinkMulticast {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();
        ArrayList<Object> list = new ArrayList<>();

        flux.subscribe(System.out::println);
        flux.subscribe(list::add);

        for (int i = 1; i <= 1000; i++) {
            int j = i;
            CompletableFuture.runAsync(() ->
                    sink.emitNext(j, (s,e) -> true));
        }

        sleep(5);
        System.out.println(list.size());
    }
}
