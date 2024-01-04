package com.mastercode.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import static com.mastercode.utils.Util.subscriber;

public class Lec08SinkMultiDirectAll {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();

        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(subscriber("ali"));
        flux.subscribe(subscriber("vali"));

        sink.tryEmitNext("?");
        flux.subscribe(subscriber("pirvali"));

        sink.tryEmitNext("fine");
    }
}
