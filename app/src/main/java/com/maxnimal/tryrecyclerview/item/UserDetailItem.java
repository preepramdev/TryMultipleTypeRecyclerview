package com.maxnimal.tryrecyclerview.item;

import com.maxnimal.tryrecyclerview.OrderDetailType;

public class UserDetailItem extends BaseOrderDetailItem {
    private String name;

    public UserDetailItem() {
        super(OrderDetailType.TYPE_USER_DETAIL);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
