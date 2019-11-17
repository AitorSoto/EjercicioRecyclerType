package com.example.ejerciciorecoclertype;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder1 extends RecyclerView.ViewHolder {

    TextView txtCorto;

    public Holder1(@NonNull View itemView) {
        super(itemView);
        txtCorto = itemView.findViewById(R.id.txt_title);
    }

    public void bind(Dato datos)
    {
        txtCorto.setText(datos.getTextoCorto());
    }
}