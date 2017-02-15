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
import com.ciglesias.petagram.db.BaseDatos;
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
        BaseDatos baseDatos = new BaseDatos(getContext());

        listMascotas = baseDatos.obtenerTodasLasMAscotas();

        recyclerViewMascotas = (RecyclerView) v.findViewById(R.id.id_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(listMascotas,getContext());

        recyclerViewMascotas.setLayoutManager(linearLayoutManager);
        recyclerViewMascotas.setAdapter(mascotaAdaptador);

        return v;
    }


}
