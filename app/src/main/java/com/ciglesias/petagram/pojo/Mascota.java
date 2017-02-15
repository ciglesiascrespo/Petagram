package com.ciglesias.petagram.pojo;

/**
 * Created by Ciglesias-pc on 12/02/2017.
 */
public class Mascota {
    private String nombre;
    private int nroLikes, idImage,idMascota;

    public Mascota(String nombre, int nroLikes, int idImage) {
        this.nombre = nombre;
        this.nroLikes = nroLikes;
        this.idImage = idImage;
    }


    public Mascota(int id,String nombre, int nroLikes, int idImage) {
        this.nombre = nombre;
        this.nroLikes = nroLikes;
        this.idImage = idImage;
        this.idMascota = id;
    }
    public int getIdMascota() {
        return idMascota;
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
