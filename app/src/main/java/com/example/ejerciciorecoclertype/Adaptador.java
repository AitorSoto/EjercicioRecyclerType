package com.example.ejerciciorecoclertype;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener{

    Context context;
    Dato datos;
    View.OnClickListener listener;
    View.OnLongClickListener longListener;
    onImagenClickListener listenerImg;
    onClickBotonListener listenerbtn;

    public Adaptador(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if (viewType == 0)
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_1,parent,false);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            return new Holder1(v);
        }
        else if (viewType == 1)
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_2,parent,false);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);

            Holder2 holder2 = new Holder2(v);
            holder2.ClickImagen(new onImagenClickListener() {
                @Override
                public void onImagenClick(Dato dato) {
                    listenerImg.onImagenClick(dato);
                }
            });
            return holder2;
        }
        else
        {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_3,parent,false);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);

            Holder3 holder3 = new Holder3(v);
            holder3.ClickBoton(new onClickBotonListener() {
                @Override
                public void onClickBoton(Dato dato) {
                    listenerbtn.onClickBoton(dato);
                }
            });
            return holder3;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position))
        {
            case 0:
                ((Holder1)holder).bind(((MainActivity)context).datos.get(position));
                break;
            case 1:
                ((Holder2)holder).bind(((MainActivity)context).datos.get(position));
                break;
            case 2:
                ((Holder3)holder).bind(((MainActivity)context).datos.get(position));
                break;
            case 3:
                ((Holder3)holder).bind(((MainActivity)context).datos.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return ((MainActivity)context).datos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public void setClickListener(View.OnClickListener listener)
    {
        if(listener != null)
            this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) listener.onClick(v);
    }


    public void setLongListener(View.OnLongClickListener longListener)
    {
        if (longListener != null)
            this.longListener = longListener;
    }

    @Override
    public boolean onLongClick(View v) {
        if (longListener != null)
            longListener.onLongClick(v);
        return true;
    }

    public void clickImagen(onImagenClickListener listener)
    {
        if (listener != null) listenerImg = listener;
    }

    public void clickBoton(onClickBotonListener listener)
    {
        if (listener != null) listenerbtn = listener;
    }
}
