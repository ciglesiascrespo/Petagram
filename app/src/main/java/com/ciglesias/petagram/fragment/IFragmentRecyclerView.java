package com.ciglesias.petagram.fragment;

import com.ciglesias.petagram.adaptor.MascotaAdaptador;
import com.ciglesias.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 19/03/2017.
 */
public interface IFragmentRecyclerView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> listContactos);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
