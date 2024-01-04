package com.mastercode.sec11;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import static com.mastercode.utils.Util.subscriber;

public class Lec03SinkOne {
    public static void main(String[] args) {
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();
        mono.subscribe(subscriber("ali"));
        mono.subscribe(subscriber("vali"));

        sink.tryEmitValue("hello");
    }
}
