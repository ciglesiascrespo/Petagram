package com.ciglesias.petagram.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciglesias.petagram.R;
import com.ciglesias.petagram.db.BaseDatos;
import com.ciglesias.petagram.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 12/02/2017.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> listMascotas;
    BaseDatos baseDatos;
    Context context;

    public MascotaAdaptador(ArrayList<Mascota> listMascotas, Context context) {
        this.listMascotas = listMascotas;
        baseDatos = new BaseDatos(context);
        this.context = context;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, final int position) {
        final Mascota itemMascota = listMascotas.get(position);

        holder.txtNombreMascota.setText(itemMascota.getNombre());
        holder.txtNroLikes.setText(String.valueOf(itemMascota.getNroLikes()));

        Picasso.with(context)
                .load(itemMascota.getIdImage())
                .into(holder.imgFoto);
//        holder.imgFoto.setImageResource(itemMascota.getIdImage());

        holder.imgBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listMascotas.get(position).setNroLikes(itemMascota.getNroLikes() + 1);
                baseDatos.actualizarNroLike(listMascotas.get(position));
                baseDatos.insertarMascotaLike(listMascotas.get(position).getIdMascota());
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView txtNombreMascota;
        private TextView txtNroLikes;
        private ImageButton imgBtnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.id_img_mascota_cardview);
            txtNombreMascota = (TextView) itemView.findViewById(R.id.id_txt_nombre_mascota_cardview);
            txtNroLikes = (TextView) itemView.findViewById(R.id.id_txt_nro_like_mascota_cardview);
            imgBtnLike = (ImageButton) itemView.findViewById(R.id.id_img_btn_like_cardview);
        }
    }
}
