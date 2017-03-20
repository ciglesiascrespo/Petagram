package com.ciglesias.petagram.fragment;

import com.ciglesias.petagram.adaptor.MascotaAdaptador;
import com.ciglesias.petagram.adaptor.MiMascotaAdaptor;
import com.ciglesias.petagram.pojo.MascotaImages;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 19/03/2017.
 */
public interface IFragmentMiMacsota {

    public void generarGridLayoutManager();

    public MiMascotaAdaptor crearAdaptador(ArrayList<MascotaImages> listMascotaImages);

    public void inicializarAdaptadorRV(MiMascotaAdaptor adaptador);

    public void mostrarInformacionUsuario(String nombre, String urlPerfil);
}
