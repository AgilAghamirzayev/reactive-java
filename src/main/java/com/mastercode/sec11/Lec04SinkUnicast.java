package com.mastercode.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import static com.mastercode.utils.Util.subscriber;

public class Lec04SinkUnicast {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(subscriber("ali"));

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");
        sink.tryEmitNext("?");
    }
}
