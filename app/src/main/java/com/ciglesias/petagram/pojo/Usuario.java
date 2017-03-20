package com.ciglesias.petagram.pojo;

/**
 * Created by Ciglesias-pc on 20/03/2017.
 */
public class Usuario {
    private String urlImage ="";
    private String fullName = "";
    private String id = "";

    public Usuario(String urlImage, String fullName, String id) {
        this.urlImage = urlImage;
        this.fullName = fullName;
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
