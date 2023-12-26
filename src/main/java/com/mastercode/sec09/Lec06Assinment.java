package com.mastercode.sec09;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import com.mastercode.sec09.assignment.OrderProcessor;
import com.mastercode.sec09.assignment.OrderService;
import com.mastercode.sec09.assignment.PurchaseOrder;
import java.time.Duration;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import reactor.core.publisher.Flux;

public class Lec06Assinment {

    public static void main(String[] args) {
        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
                "Kids", OrderProcessor.kidsProcessing(),
                "Automotive", OrderProcessor.automotiveProcessing()
        );

        Set<String> set = map.keySet();

        OrderService.orderStream()
                .filter(p -> set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(subscriber());

        sleep(60);
    }


}
