package com.maxnimal.tryrecyclerview.viewholder;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.R;

public class ButtonViewHolder extends RecyclerView.ViewHolder {
    public Button btnPositive;
    public Button btnNegative;

    public ButtonViewHolder(@NonNull View itemView) {
        super(itemView);
        btnPositive = (Button) itemView.findViewById(R.id.btn_positive);
        btnNegative = (Button) itemView.findViewById(R.id.btn_negative);
    }
}
