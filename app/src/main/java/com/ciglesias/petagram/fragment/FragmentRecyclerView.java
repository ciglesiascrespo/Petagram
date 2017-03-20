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
import com.ciglesias.petagram.presentador.FragmentRecyclerViewPresenter;
import com.ciglesias.petagram.presentador.IFragmentRecyclerViewPresenter;

import java.util.ArrayList;

public class FragmentRecyclerView extends Fragment implements IFragmentRecyclerView {

    RecyclerView recyclerViewMascotas;

    private IFragmentRecyclerViewPresenter presenter;

    public FragmentRecyclerView() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_recycler_view, container, false);
        recyclerViewMascotas = (RecyclerView) v.findViewById(R.id.id_recyclerview);
        presenter = new FragmentRecyclerViewPresenter(this, getContext());
        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> listMascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(listMascotas, getContext());
        return mascotaAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        recyclerViewMascotas.setAdapter(adaptador);
    }
}
