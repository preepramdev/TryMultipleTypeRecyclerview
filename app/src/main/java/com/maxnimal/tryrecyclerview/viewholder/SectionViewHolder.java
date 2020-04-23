package com.maxnimal.tryrecyclerview.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.R;

public class SectionViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout layoutSectionContainer;
    public TextView tvSection;

    public SectionViewHolder(View itemView) {
        super(itemView);
        layoutSectionContainer = (LinearLayout) itemView.findViewById(R.id.layout_section_container);
        tvSection = (TextView) itemView.findViewById(R.id.tv_section);
    }
}
