package com.mastercode.sec08;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.mastercode.utils.Util.*;

public class Lec06Assignment {
    public static void main(String[] args) {
        int carPrice = 10000;

        Flux.combineLatest(monthlyStream(), demandStream(),
                        (month, demand) -> (carPrice - (month * 100)) * demand)
                .subscribe(subscriber());

        sleep(50);
    }

    private static Flux<Long> monthlyStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> demandStream() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> faker().random().nextInt(80, 120) / 100d)
                .startWith(1d);
    }

}
