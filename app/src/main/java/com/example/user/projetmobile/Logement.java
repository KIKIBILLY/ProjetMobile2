package com.example.user.projetmobile;

import java.io.Serializable;

/**
 * Created by User on 27/03/2017.
 */

public class Logement implements Serializable {
    private  String adresse;
    private String prix;
    private String Surface;
    private String nbchambre;

    private int id_image;
    public int [] imageResources = new int[6];
    private String Region;
    private String Type;


    public Logement(String adresse,String prix, String surface, String  nbchambre, int id_image, String region,String Type , int i1,int i2,int i3,int i4, int i5) {
        this.adresse=adresse;
        this.prix = prix;
        this.Surface = surface;
        this.nbchambre = nbchambre;
        this.id_image = id_image;
        this.Region = region;
        this.Type=Type;
        imageResources [1]= i1;
        imageResources [2]= i2;
        imageResources [3]= i3;
        imageResources [4]= i4;
        imageResources [5]= i5;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse){this.adresse=adresse;}

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getSurface() {
        return Surface;
    }

    public void setSurface(String surface) {
        Surface = surface;
    }

    public String getNbchambre() {
        return nbchambre;
    }

    public void setNbchambre(String nbchambre) {
        this.nbchambre = nbchambre;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }
}