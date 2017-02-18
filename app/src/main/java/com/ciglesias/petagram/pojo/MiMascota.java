package com.ciglesias.petagram.pojo;

/**
 * Created by Ciglesias-pc on 17/02/2017.
 */
public class MiMascota {
    private int nroLikes,idImg;

    public MiMascota(int nroLikes, int idImg) {
        this.nroLikes = nroLikes;
        this.idImg = idImg;
    }

    public int getNroLikes() {
        return nroLikes;
    }

    public void setNroLikes(int nroLikes) {
        this.nroLikes = nroLikes;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }
}
