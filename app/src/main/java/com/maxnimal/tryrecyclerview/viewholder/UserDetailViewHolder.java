package com.maxnimal.tryrecyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.R;

public class UserDetailViewHolder extends RecyclerView.ViewHolder {
    public TextView tvUserName;

    public UserDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        tvUserName = (TextView) itemView.findViewById(R.id.tv_user_name);
    }
}
