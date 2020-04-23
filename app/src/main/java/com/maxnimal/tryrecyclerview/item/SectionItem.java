package com.maxnimal.tryrecyclerview.item;

import com.maxnimal.tryrecyclerview.OrderDetailType;

public class SectionItem extends BaseOrderDetailItem {
    private String section;

    public SectionItem() {
        super(OrderDetailType.TYPE_SECTION);
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
