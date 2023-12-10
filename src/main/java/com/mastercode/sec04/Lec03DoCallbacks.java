package com.mastercode.sec04;

import reactor.core.publisher.Flux;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.subscriber;

public class Lec03DoCallbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    System.out.println("started");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                    System.out.println("completed");
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst"))
                .doOnNext(o -> System.out.println("doOnNext: " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe: " + s))
                .doOnRequest(l -> System.out.println("doOnRequest: " + l))
                .doOnError(e -> System.out.println("doOnError: " + e))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doFinally(signalType -> System.out.println("doFinally: " + signalType))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
                .subscribe(subscriber());
    }

}
