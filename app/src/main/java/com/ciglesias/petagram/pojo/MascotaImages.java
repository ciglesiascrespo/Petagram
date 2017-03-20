package com.ciglesias.petagram.pojo;

/**
 * Created by Ciglesias-pc on 19/03/2017.
 */
public class MascotaImages {
    private String id, urlImage,urlImagePerfil,nombrePerfil;
    private int nroLikes;

    public MascotaImages(String id, String urlImage, int nroLikes,String urlImagePerfil , String nombrePerfil) {
        this.id = id;
        this.urlImage = urlImage;
        this.nroLikes = nroLikes;
        this.nombrePerfil = nombrePerfil;
        this.urlImagePerfil =urlImagePerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public String getUrlImagePerfil() {
        return urlImagePerfil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getNroLikes() {
        return nroLikes;
    }

    public void setNroLikes(int nroLikes) {
        this.nroLikes = nroLikes;
    }
}
