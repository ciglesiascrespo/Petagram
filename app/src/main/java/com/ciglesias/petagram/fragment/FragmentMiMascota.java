package com.ciglesias.petagram.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciglesias.petagram.R;
import com.ciglesias.petagram.adaptor.MiMascotaAdaptor;
import com.ciglesias.petagram.pojo.MiMascota;

import java.util.ArrayList;

public class FragmentMiMascota extends Fragment {
    RecyclerView recyclerViewMiMascota;
    ArrayList<MiMascota> listMiMascotas;

    public FragmentMiMascota() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment_mi_mascota, container, false);

        listMiMascotas = new ArrayList<>();

        listMiMascotas.add(new MiMascota( 0, R.drawable.img_kelpie1));
        listMiMascotas.add(new MiMascota( 2, R.drawable.img_kelpie2));
        listMiMascotas.add(new MiMascota( 3, R.drawable.img_kelpie3));
        listMiMascotas.add(new MiMascota( 5, R.drawable.img_kelpie4));
        listMiMascotas.add(new MiMascota( 0, R.drawable.img_kelpie5));
        listMiMascotas.add(new MiMascota( 0, R.drawable.img_kelpie6));
        listMiMascotas.add(new MiMascota( 1, R.drawable.img_kelpie7));
        listMiMascotas.add(new MiMascota( 2, R.drawable.img_kelpie10));
        listMiMascotas.add(new MiMascota(4, R.drawable.img_kelpie11));
        listMiMascotas.add(new MiMascota(6, R.drawable.img_kelpie12));
        listMiMascotas.add(new MiMascota(7, R.drawable.img_kelpie13));

        recyclerViewMiMascota = (RecyclerView) v.findViewById(R.id.id_recyclerview_mi_mascota);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);

        MiMascotaAdaptor mascotaAdaptador = new MiMascotaAdaptor(listMiMascotas);

        recyclerViewMiMascota.setLayoutManager(gridLayoutManager);
        recyclerViewMiMascota.setAdapter(mascotaAdaptador);

        return v;
    }
}
