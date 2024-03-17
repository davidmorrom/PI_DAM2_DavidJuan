package com.mycode.pi_dam2_davidjuan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> implements View.OnClickListener {
    private ArrayList<ItemLista> datos;
    private View.OnClickListener listener;
    public static class MiViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView textoSup;
        private TextView textoInf;
        public MiViewHolder(View view) {
            super(view);
            imagen = (ImageView) view.findViewById(R.id.imageView);
            textoSup = (TextView) view.findViewById(R.id.tvSuperior);
            textoInf = (TextView) view.findViewById(R.id.tvInferior);
        }
        public void bindListaItem(ItemLista li) {
            imagen.setImageResource(li.getImagen());
            textoSup.setText(li.getTextoSup());
            textoInf.setText(li.getTextoInf());
        }
    }
    public MiAdaptador(ArrayList<ItemLista> datos) {
        this.datos = datos;
    }
    @Override
    public MiViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        v.setOnClickListener(this);
        MiViewHolder vh = new MiViewHolder(v);
        return vh;
    }
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

