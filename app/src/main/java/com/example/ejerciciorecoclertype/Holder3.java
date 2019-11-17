package com.example.ejerciciorecoclertype;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder3 extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView txtCorto;
    ImageView imageView;
    TextView textoLargo;
    Button boton1;
    Button boton2;
    onClickBotonListener listenerBoton;
    Dato datos;

    public Holder3(@NonNull View itemView) {
        super(itemView);
        txtCorto = itemView.findViewById(R.id.txt_title);
        imageView = itemView.findViewById(R.id.imageView);
        textoLargo = itemView.findViewById(R.id.textViewL);
        boton1 = itemView.findViewById(R.id.bShare);
        boton2 = itemView.findViewById(R.id.bExplore);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    public void bind(Dato datos)
    {
        txtCorto.setText(datos.getTextoCorto());
        imageView.setImageBitmap(datos.getFoto());
        textoLargo.setText(datos.getTextoLargo());
    }

    public void ClickBoton(onClickBotonListener listener)
    {
        if(listener != null)
            this.listenerBoton = listener;
    }

    @Override
    public void onClick(View v) {
        if (listenerBoton != null)
            listenerBoton.onClickBoton(datos);
    }
}
