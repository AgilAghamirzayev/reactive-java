package com.mastercode.sec10;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import static com.mastercode.utils.Util.*;

public class Lec05RetryWhenAdvanced {

    public static void main(String[] args) {
        orderService(faker().business().creditCardNumber())
                .doOnError(err -> System.err.println(err.getMessage()))
                .retryWhen(Retry.from(
                        flux -> flux
                                .doOnNext(rs -> {
                                    System.out.println(rs.totalRetries());
                                    System.out.println(rs.failure());
                                })
                                .handle(((retrySignal, synchronousSink) -> {
                                    if (retrySignal.failure().getMessage().equals("500")) {
                                        synchronousSink.next(1);
                                    } else {
                                        synchronousSink.error(retrySignal.failure());
                                    }
                                })).delayElements(Duration.ofSeconds(1))

                ))
                .subscribe(subscriber());

        sleep(60);
    }

    private static Mono<String> orderService(String ccNumber) {
        return Mono.fromSupplier(() -> {
            processPayment(ccNumber);
            return faker().idNumber().valid();
        });
    }

    private static void processPayment(String ccNumber) {
        int random = faker().random().nextInt(1, 10);
        if (random < 8) {
            throw new RuntimeException("500");
        }
        if (random < 10) {
            throw new RuntimeException("404");
        }
    }

}
