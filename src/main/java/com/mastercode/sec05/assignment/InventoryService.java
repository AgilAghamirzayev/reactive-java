package com.mastercode.sec05.assignment;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class InventoryService {
    private final Map<String, Integer> db = new HashMap<>();


    public InventoryService() {
        db.put("Kids", 100);
        db.put("Automotive", 100);
    }

    public Consumer<PurchaseOrder> subscribeOrderStream() {
        return p -> db.computeIfPresent(p.getCategory(), (k, v) -> {
            if (v > 0) {
                return v - p.getQuantity();
            }
            throw new RuntimeException("There in no more items");
        });
    }

    public Flux<String> inventoryStream() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> db.toString())
                .subscribeOn(Schedulers.boundedElastic());
    }
}
