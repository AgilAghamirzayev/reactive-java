package com.mastercode.sec10;

import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

public class Lec04RetryWhen {

    public static final AtomicInteger atomic = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3)))
                .subscribe(subscriber());

        sleep(20);
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("-Completed-"))
                .map(i -> i / 0)
                .doOnError(err -> System.out.println("--error"));
    }

}
