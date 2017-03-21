package com.example.user.projetmobile;

import java.io.Serializable;

/**
 * Created by User on 21/03/2017.
 */

public class Logements implements Serializable {
    private String  prix;
    private String  nombre_chambre;
    private String  surface;
    private int id_image;

    public Logements(String prix, String nombre_chambre, String surface, int id_image) {
        this.prix = prix;
        this.nombre_chambre = nombre_chambre;
        this.surface = surface;
        this.id_image = id_image;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getNombre_chambre() {
        return nombre_chambre;
    }

    public void setNombre_chambre(String nombre_chambre) {
        this.nombre_chambre = nombre_chambre;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }
}
