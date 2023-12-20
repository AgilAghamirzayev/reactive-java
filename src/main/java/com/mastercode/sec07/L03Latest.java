package com.mastercode.sec07;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.sleepMillis;
import static com.mastercode.utils.Util.subscriber;

import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class L03Latest {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
                    for (int i = 1; i <= 500; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                        sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> sleepMillis(10))
                .subscribe(subscriber());

        sleep(10);
    }
}
