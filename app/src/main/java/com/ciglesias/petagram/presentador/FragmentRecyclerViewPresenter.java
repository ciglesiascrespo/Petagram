package com.ciglesias.petagram.presentador;

import android.content.Context;

import com.ciglesias.petagram.db.BaseDatos;
import com.ciglesias.petagram.fragment.IFragmentRecyclerView;
import com.ciglesias.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 19/03/2017.
 */
public class FragmentRecyclerViewPresenter implements IFragmentRecyclerViewPresenter {
    private IFragmentRecyclerView iRecyclerViewFragmentView;
    private Context context;
    private ArrayList<Mascota> listMascotas;


    public FragmentRecyclerViewPresenter(IFragmentRecyclerView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotas();
//        obtenerMediosRecientes();
    }


    @Override
    public void obtenerMascotas() {
        BaseDatos baseDatos = new BaseDatos(context);
        listMascotas = baseDatos.obtenerTodasLasMAscotas();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(listMascotas));
    }

}
