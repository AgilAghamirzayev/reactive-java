package com.mastercode.sec09;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec01Buffer3 {
    public static void main(String[] args) {
        eventStream()
                .bufferTimeout(5, Duration.ofSeconds(2))
                .subscribe(subscriber());

        sleep(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(10))
                .map(i -> "event-" + i);
    }
}
