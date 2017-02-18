package com.ciglesias.petagram.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciglesias.petagram.R;
import com.ciglesias.petagram.adaptor.MascotaAdaptador;
import com.ciglesias.petagram.pojo.Mascota;

import java.util.ArrayList;

public class FragmentRecyclerView extends Fragment {

    RecyclerView recyclerViewMascotas;
    ArrayList<Mascota> listMascotas;

    public FragmentRecyclerView() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_recycler_view, container, false);

        listMascotas = new ArrayList<>();

        listMascotas.add(new Mascota("Alex", 0, R.drawable.img_mascota_1));
        listMascotas.add(new Mascota("Dante", 2, R.drawable.img_mascota_2));
        listMascotas.add(new Mascota("Kelpie", 3, R.drawable.img_mascota_3));
        listMascotas.add(new Mascota("Kiba", 5, R.drawable.img_mascota_4));
        listMascotas.add(new Mascota("Akamaru", 0, R.drawable.img_mascota_5));
        listMascotas.add(new Mascota("Tyson", 0, R.drawable.img_mascota_6));
        listMascotas.add(new Mascota("Tom", 0, R.drawable.img_mascota_7));
        listMascotas.add(new Mascota("Toby", 0, R.drawable.img_mascota_8));
        listMascotas.add(new Mascota("Firulais", 0, R.drawable.img_mascota_9));

        recyclerViewMascotas = (RecyclerView) v.findViewById(R.id.id_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(listMascotas);

        recyclerViewMascotas.setLayoutManager(linearLayoutManager);
        recyclerViewMascotas.setAdapter(mascotaAdaptador);

        return v;
    }


}
