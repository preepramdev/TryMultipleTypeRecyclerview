package com.maxnimal.tryrecyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.R;

public class OrderViewHolder extends RecyclerView.ViewHolder {
    public TextView tvOrderName;
    public TextView tvOrderDetail;
    public TextView tvOrderPrice;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        tvOrderName = (TextView) itemView.findViewById(R.id.tv_order_name);
        tvOrderDetail = (TextView) itemView.findViewById(R.id.tv_order_detail);
        tvOrderPrice = (TextView) itemView.findViewById(R.id.tv_order_price);
    }
}
