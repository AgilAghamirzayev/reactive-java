package com.mastercode.sec09;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import com.mastercode.sec09.helper.BookOrder;
import com.mastercode.sec09.helper.RevenueReport;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec04Window {

    private static final AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {
        eventStream()
                .window(5)
                .flatMap(Lec04Window::saveEvens)
                .subscribe(subscriber());

        sleep(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "event-" + i);
    }

    private static Mono<Integer> saveEvens(Flux<String> flux) {
        return flux
                .doOnNext(e -> System.out.println("saving " + e))
                .doOnComplete(() -> {
                    System.out.println("saved this batch");
                    System.out.println("-------------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }
}
