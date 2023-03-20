package com.coolerp.gestionstockapi.web.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@JsonFilter("monFiltreDynamyque")
@Entity
public class Magasin {
    @Id
    //@GeneratedValue
    private int id_Magasin;
    private String Designation;
    private String Localisation;


    //Information A Cacher
    private double Coordo;

    public Magasin(){
    }

    public Magasin(int id_magasin, String designation, String localisation, double coordo) {
        this.id_Magasin = id_magasin;
        this.Designation = designation;
        this.Localisation = localisation;
        this.Coordo = coordo;
    }

    public int getId_Magasin(){
        return id_Magasin;
    }

    public void setId_Magasin(int id_Magasin){
        this.id_Magasin = id_Magasin;
    }

    public String getDesignation(){
        return Designation;
    }

    public void setDesignation(String Designation){
        this.Designation = Designation;
    }

    public String getLocalisation(){
        return Localisation;
    }

    public void setLocalisation(String Localisation){
        this.Localisation = Localisation;
    }

    public double getCoordo(){
        return Coordo;
    }

    public void setCoordo(double Coordo){
        this.Coordo = Coordo;
    }

    @Override
    public String toString(){
        return "Magasin{" +
                "id=" + id_Magasin +
                ", Designation=" + Designation + "\'" +
                ", Localisation=" + Localisation + "\'" +
                ", Coordo=" + Coordo +
                "}";
    }
}
