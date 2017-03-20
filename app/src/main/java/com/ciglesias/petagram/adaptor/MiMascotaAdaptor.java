package com.ciglesias.petagram.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciglesias.petagram.R;
import com.ciglesias.petagram.pojo.MascotaImages;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 17/02/2017.
 */
public class MiMascotaAdaptor extends RecyclerView.Adapter<MiMascotaAdaptor.MiMascotaViewHolder> {
    ArrayList<MascotaImages> listMascotas;
    Context context;

    public MiMascotaAdaptor(ArrayList<MascotaImages> listMascotas, Context context) {
        this.listMascotas = listMascotas;
        this.context = context;
    }

    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota, parent, false);

        return new MiMascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiMascotaViewHolder holder, final int position) {
        final MascotaImages itemMascota = listMascotas.get(position);

        holder.txtNroLikes.setText(String.valueOf(itemMascota.getNroLikes()));
        Picasso.with(context)
                .load(itemMascota.getUrlImage())
                .into(holder.imgFoto);
//        holder.imgFoto.setImageResource(itemMascota.getIdImg());

    }

    @Override
    public int getItemCount() {
        return listMascotas.size();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView txtNroLikes;


        public MiMascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.id_img_mi_mascota_cardview);
            txtNroLikes = (TextView) itemView.findViewById(R.id.id_txt_nro_like_mi_mascota_cardview);

        }
    }
}
