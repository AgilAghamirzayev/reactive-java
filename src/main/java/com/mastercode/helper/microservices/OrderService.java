package com.mastercode.helper.microservices;

import com.mastercode.helper.PurchaseOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Flux;

public class OrderService {
    private static final Map<Integer, List<PurchaseOrder>> database = new HashMap<>();

    static {
        database.put(1,
                List.of(
                        new PurchaseOrder(1),
                        new PurchaseOrder(1),
                        new PurchaseOrder(1)
                )
        );

        database.put(2,
                List.of(
                        new PurchaseOrder(2),
                        new PurchaseOrder(2)
                )
        );
    }

    public static Flux<PurchaseOrder> getOrders(int userId) {
        return Flux.create(purchaseOrderFluxSink -> {
                    database.get(userId).forEach(purchaseOrderFluxSink::next);
                    purchaseOrderFluxSink.complete();
                }
        );
    }
}
