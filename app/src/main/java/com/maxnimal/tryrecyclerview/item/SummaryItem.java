package com.maxnimal.tryrecyclerview.item;

import com.maxnimal.tryrecyclerview.OrderDetailType;

public class SummaryItem extends BaseOrderDetailItem {
    private String name;
    private String price;

    public SummaryItem() {
        super(OrderDetailType.TYPE_SUMMARY);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
