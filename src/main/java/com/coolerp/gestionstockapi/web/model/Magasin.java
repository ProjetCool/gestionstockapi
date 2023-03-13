package com.coolerp.gestionstockapi.web.model;

public class Magasin {
    private int id_Magasin;
    private String Designation;
    private String Localisation;

    public Magasin() {
    }

    public Magasin(int id_Magasin, String Designation, String Localisation){
        this.id_Magasin = id_Magasin;
        this.Designation = Designation;
        this.Localisation = Localisation;
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

    @Override
    public String toString() {
        return "Magasin{" +
                "id_Magasin=" + id_Magasin +
                ", Designation=" + Designation + '\'' +
                ", Localisation=" + Localisation +
                "}";
    }
}
