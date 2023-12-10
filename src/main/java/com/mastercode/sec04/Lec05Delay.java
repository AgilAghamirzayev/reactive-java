package com.mastercode.sec04;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

public class Lec05Delay {
    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .limitRate(4)
                .delayElements(Duration.ofSeconds(1))
                .subscribe(subscriber());

        sleep(10);
    }

}
