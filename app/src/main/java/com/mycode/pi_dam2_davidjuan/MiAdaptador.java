package com.mycode.pi_dam2_davidjuan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> implements View.OnClickListener {
    private ArrayList<ItemLista> datos;
    private View.OnClickListener listener;

    public static class MiViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView textoNombre;
        private TextView textoPie;

        public MiViewHolder(View view) {
            super(view);
            imagen = (ImageView) view.findViewById(R.id.imageView);
            textoNombre = (TextView) view.findViewById(R.id.tvAccountName);
            textoPie = (TextView) view.findViewById(R.id.tvCaption);
        }

        public void bindListaItem(ItemLista li) {
            Glide.with(imagen.getContext())
                    .load(li.getImagen())
                    .into(imagen);
            textoNombre.setText(li.getTextoNombre());
            textoPie.setText(li.getTextoPie());
        }
    }

    public MiAdaptador(ArrayList<ItemLista> datos) {
        this.datos = datos;
    }

    @Override
    public MiAdaptador.MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        v.setOnClickListener(this);
        MiViewHolder vh = new MiViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        holder.bindListaItem(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
