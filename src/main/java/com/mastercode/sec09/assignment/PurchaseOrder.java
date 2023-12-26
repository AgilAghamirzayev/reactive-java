package com.mastercode.sec09.assignment;

import static com.mastercode.utils.Util.faker;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private BigDecimal price;
    private String category;

    public PurchaseOrder() {
        this.item = faker().commerce().productName();
        this.price = BigDecimal.valueOf(Double.parseDouble(faker().commerce().price()));
        this.category = faker().commerce().department();
    }
}
