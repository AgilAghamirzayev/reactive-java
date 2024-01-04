package com.mastercode.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

public class Lec09SinkMultiDirectAll {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small","16");

        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(subscriber("ali"));
        flux.delayElements(Duration.ofMillis(200)).subscribe(subscriber("vali"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        sleep(10);
    }
}
