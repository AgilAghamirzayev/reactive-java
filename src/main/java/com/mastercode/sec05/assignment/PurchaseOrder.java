package com.mastercode.sec05.assignment;

import static com.mastercode.utils.Util.faker;

import java.math.BigDecimal;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private BigDecimal price;
    private String category;
    private Integer quantity;

    public PurchaseOrder() {
        this.item = faker().commerce().productName();
        this.price = BigDecimal.valueOf(Double.parseDouble(faker().commerce().price()));
        this.category = faker().commerce().department();
        this.quantity = faker().random().nextInt(1, 10);
    }
}
