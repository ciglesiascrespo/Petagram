package com.ciglesias.petagram.restApi.model;

import com.ciglesias.petagram.pojo.Usuario;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 20/03/2017.
 */
public class UserResponse {
private ArrayList<Usuario> usuarios;

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
