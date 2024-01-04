package com.mastercode.sec11;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import static com.mastercode.utils.Util.subscriber;

public class Lec02SinkOne {
    public static void main(String[] args) {
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();
        mono.subscribe(subscriber("ali"));

        sink.emitValue("hi", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return true;
        }));

        sink.emitValue("hi", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        }));
    }
}
