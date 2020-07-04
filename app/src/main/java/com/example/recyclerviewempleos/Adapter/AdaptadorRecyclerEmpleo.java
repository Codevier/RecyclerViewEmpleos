package com.example.recyclerviewempleos.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerviewempleos.Model.Empleo;
import com.example.recyclerviewempleos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorRecyclerEmpleo extends RecyclerView.Adapter<AdaptadorRecyclerEmpleo.ViewHolder> {
    ArrayList<Empleo> listaUsuarios;

    public AdaptadorRecyclerEmpleo(ArrayList<Empleo> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.ly_item, null);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.empleo.setText(listaUsuarios.get(position).getOfertaLaboral());
        holder.empresa.setText("Empresa: "+listaUsuarios.get(position).getEmpresa());
        holder.cargo.setText(listaUsuarios.get(position).getCargo());
        holder.descip.setText(listaUsuarios.get(position).getDescripcion());
        Picasso.get().load(listaUsuarios.get(position).getImagen()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView empleo, cargo, empresa, descip;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            empleo= (TextView) itemView.findViewById(R.id.lblEmpleo);
            empresa=(TextView) itemView.findViewById(R.id.lblDato);
            cargo= (TextView) itemView.findViewById(R.id.lblCargo);
            descip=(TextView) itemView.findViewById(R.id.lblDescripcion);
            imageView = (ImageView)itemView.findViewById(R.id.imgUrl);
        }
    }
}
