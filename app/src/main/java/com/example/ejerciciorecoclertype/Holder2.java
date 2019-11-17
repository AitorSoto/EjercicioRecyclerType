package com.example.ejerciciorecoclertype;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder2 extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView txtCorto;
    ImageView imageView;
    onImagenClickListener listener;
    ImageView boton1;
    ImageView boton2;
    ImageView boton3;
    Dato datos;

    public Holder2(@NonNull View itemView) {
        super(itemView);
        txtCorto = itemView.findViewById(R.id.txt_title);
        imageView = itemView.findViewById(R.id.imageView);
        boton1 = itemView.findViewById(R.id.imageView1);
        boton2 = itemView.findViewById(R.id.imageView2);
        boton3 = itemView.findViewById(R.id.imageView3);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
    }

    public void bind(Dato datos)
    {
        txtCorto.setText(datos.getTextoCorto());
        imageView.setImageBitmap(datos.getFoto());
    }

    public void ClickImagen(onImagenClickListener listener)
    {
        if(listener != null)
            this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onImagenClick(datos);
    }
}