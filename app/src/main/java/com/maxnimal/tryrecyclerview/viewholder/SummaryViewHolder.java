package com.maxnimal.tryrecyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.R;

public class SummaryViewHolder extends RecyclerView.ViewHolder {
    public TextView tvSummaryName;
    public TextView tvSummaryPrice;

    public SummaryViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSummaryName = (TextView) itemView.findViewById(R.id.tv_summary_name);
        tvSummaryPrice = (TextView) itemView.findViewById(R.id.tv_summary_price);
    }
}
