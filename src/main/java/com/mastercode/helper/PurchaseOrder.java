package com.mastercode.helper;

import static com.mastercode.utils.Util.faker;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private String price;
    private Integer userId;

    public PurchaseOrder(Integer userId) {
        this.userId = userId;
        this.item = faker().commerce().productName();
        this.price = faker().commerce().price();
    }
}
