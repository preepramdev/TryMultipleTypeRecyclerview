package com.maxnimal.tryrecyclerview.item;

import com.maxnimal.tryrecyclerview.OrderDetailType;

public class TotalItem extends BaseOrderDetailItem {
    private String totalPrice;

    public TotalItem() {
        super(OrderDetailType.TYPE_TOTAL);
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
