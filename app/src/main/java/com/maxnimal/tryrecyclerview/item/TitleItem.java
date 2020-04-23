package com.maxnimal.tryrecyclerview.item;

import com.maxnimal.tryrecyclerview.OrderDetailType;

public class TitleItem extends BaseOrderDetailItem {
    private String title;

    public TitleItem(int type) {
        super(OrderDetailType.TYPE_TITLE);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
