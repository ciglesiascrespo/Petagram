package com.ciglesias.petagram;

/**
 * Created by Ciglesias-pc on 12/02/2017.
 */
public class Mascota {
    private String nombre;
    private int nroLikes, idImage;

    public Mascota(String nombre, int nroLikes, int idImage) {
        this.nombre = nombre;
        this.nroLikes = nroLikes;
        this.idImage = idImage;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroLikes() {
        return nroLikes;
    }

    public void setNroLikes(int nroLikes) {
        this.nroLikes = nroLikes;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
