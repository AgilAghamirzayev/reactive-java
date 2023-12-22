package com.mastercode.sec08.helper;

import static com.mastercode.utils.Util.faker;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Qatar {
    public static Flux<String> getFlights() {
        return Flux.range(1, faker().random().nextInt(1,5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Qatar " + faker().random().nextInt(100,999))
                .filter(i -> faker().random().nextBoolean());
    }
}
