package com.ciglesias.petagram.restApi.model;

import com.ciglesias.petagram.pojo.MascotaImages;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 17/03/2017.
 */
public class MascotaResponse {
    ArrayList<MascotaImages> listMascotas;

    public ArrayList<MascotaImages> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(ArrayList<MascotaImages> listMascotas) {
        this.listMascotas = listMascotas;
    }
}
