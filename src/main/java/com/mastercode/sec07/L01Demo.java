package com.mastercode.sec07;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.sleepMillis;
import static com.mastercode.utils.Util.subscriber;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class L01Demo {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    for (int i = 1; i <= 500; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                    }
                    fluxSink.complete();
                })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> sleepMillis(10))
                .subscribe(subscriber());

        sleep(60);
    }
}
