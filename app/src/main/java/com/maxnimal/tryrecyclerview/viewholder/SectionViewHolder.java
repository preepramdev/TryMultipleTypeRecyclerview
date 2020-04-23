package com.maxnimal.tryrecyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.R;

public class SectionViewHolder extends RecyclerView.ViewHolder {
    public TextView tvSection;

    public SectionViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSection = (TextView) itemView.findViewById(R.id.tv_section);
    }
}
