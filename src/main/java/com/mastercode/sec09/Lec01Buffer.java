package com.mastercode.sec09;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec01Buffer {
    public static void main(String[] args) {
        eventStream()
                .buffer(5)
                .subscribe(subscriber());

        sleep(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> "event-" + i);
    }
}
