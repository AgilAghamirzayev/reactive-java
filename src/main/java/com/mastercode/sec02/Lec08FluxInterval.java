package com.mastercode.sec02;

import static com.mastercode.utils.Util.onNext;
import static com.mastercode.utils.Util.sleep;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec08FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(onNext());

        sleep(6);
    }
}
