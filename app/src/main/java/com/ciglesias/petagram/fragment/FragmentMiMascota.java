package com.ciglesias.petagram.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciglesias.petagram.R;
import com.ciglesias.petagram.adaptor.MiMascotaAdaptor;
import com.ciglesias.petagram.pojo.MascotaImages;
import com.ciglesias.petagram.presentador.FragmentMiMascotaPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FragmentMiMascota extends Fragment implements IFragmentMiMacsota {
    RecyclerView recyclerViewMiMascota;
    FragmentMiMascotaPresenter presenter;
    TextView txtNombrePerfil;
    ImageView imgPerfil;
    SharedPreferences sharedPreferences;

    public FragmentMiMascota() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment_mi_mascota, container, false);
//
//        listMiMascotas = new ArrayList<>();
//
//        listMiMascotas.add(new MiMascota(0, R.drawable.img_kelpie1));
//        listMiMascotas.add(new MiMascota(2, R.drawable.img_kelpie2));
//        listMiMascotas.add(new MiMascota(3, R.drawable.img_kelpie3));
//        listMiMascotas.add(new MiMascota(5, R.drawable.img_kelpie4));
//        listMiMascotas.add(new MiMascota(0, R.drawable.img_kelpie5));
//        listMiMascotas.add(new MiMascota(0, R.drawable.img_kelpie6));
//        listMiMascotas.add(new MiMascota(1, R.drawable.img_kelpie7));
//        listMiMascotas.add(new MiMascota(2, R.drawable.img_kelpie10));
//        listMiMascotas.add(new MiMascota(4, R.drawable.img_kelpie11));
//        listMiMascotas.add(new MiMascota(6, R.drawable.img_kelpie12));
//        listMiMascotas.add(new MiMascota(7, R.drawable.img_kelpie13));
        sharedPreferences = getContext().getSharedPreferences(getResources().getString(R.string.preferencia_datos_usuario), Context.MODE_PRIVATE);

        String userId = sharedPreferences.getString(getResources().getString(R.string.preferencia_usuario), "");

        recyclerViewMiMascota = (RecyclerView) v.findViewById(R.id.id_recyclerview_mi_mascota);
        imgPerfil = (ImageView) v.findViewById(R.id.id_img_mascota_perfil);
        txtNombrePerfil = (TextView) v.findViewById(R.id.id_txt_nombre_mascota_perfil);


        presenter = new FragmentMiMascotaPresenter(getContext(), this, userId);
        return v;
    }

    @Override
    public void generarGridLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerViewMiMascota.setLayoutManager(gridLayoutManager);

    }

    @Override
    public MiMascotaAdaptor crearAdaptador(ArrayList<MascotaImages> listMascotaImages) {
        MiMascotaAdaptor mascotaAdaptador = new MiMascotaAdaptor(listMascotaImages, getContext());
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MiMascotaAdaptor adaptador) {
        recyclerViewMiMascota.setAdapter(adaptador);
    }

    @Override
    public void mostrarInformacionUsuario(String nombre, String urlPerfil) {
        txtNombrePerfil.setText(nombre);
        Picasso.with(getContext())
                .load(urlPerfil)
                .placeholder(R.drawable.img_kelpie8)
                .into(imgPerfil);
    }
}
