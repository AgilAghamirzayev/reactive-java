package com.mastercode.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

public class Lec10SinkReplay {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().replay().all();

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
