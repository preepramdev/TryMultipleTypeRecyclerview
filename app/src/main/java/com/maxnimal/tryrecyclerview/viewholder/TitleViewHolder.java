package com.maxnimal.tryrecyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.R;

public class TitleViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;

    public TitleViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }
}
