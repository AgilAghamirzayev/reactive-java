package com.mastercode.sec05.assignment;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class RevenueService {
    private final Map<String, BigDecimal> db = new HashMap<>();


    public RevenueService() {
        db.put("Kids", BigDecimal.ZERO);
        db.put("Automotive", BigDecimal.ZERO);
    }

    public Consumer<PurchaseOrder> subscribeOrderStream() {
        return p -> db.computeIfPresent(p.getCategory(), (k, v) -> v.add(p.getPrice()));
    }

    public Flux<String> revenueStream() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> db.toString())
                .subscribeOn(Schedulers.boundedElastic());
    }
}
