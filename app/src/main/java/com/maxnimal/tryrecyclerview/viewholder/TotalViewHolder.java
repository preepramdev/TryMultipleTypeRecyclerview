package com.maxnimal.tryrecyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.R;

public class TotalViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTotalPrice;

    public TotalViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTotalPrice = (TextView) itemView.findViewById(R.id.tv_total_price);
    }
}
