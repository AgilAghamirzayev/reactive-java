package com.mastercode.sec06;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec07FluxInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(100))
                .subscribe(v -> printThreadName("subscribe " + v));

        Flux.interval(Duration.ofMillis(100))
                .subscribe(v -> printThreadName("subscribe " + v));
        sleep(11);
    }

    private static void printThreadName(String message) {
        System.out.println(message + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
