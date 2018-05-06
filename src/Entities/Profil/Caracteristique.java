/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Profil;

/**
 *
 * @author Sofiene
 */
public class Caracteristique {
private int ID ;
private String corpulence ;
private String pilosite;
private String origine;
private String profession ;
private String alcool;
private String tabac ;
private String taille ;
private String cheveux ;
private String yeux ;
private String caractere ;
private String statut ;
private String cuisine ;



    public Caracteristique() {
    }

    @Override
    public String toString() {
        return "Caracteristique{" + "ID=" + ID + ", corpulence=" + corpulence + ", pilosite=" + pilosite + ", origine=" + origine + ", profession=" + profession + ", alcool=" + alcool + ", tabac=" + tabac + ", taille=" + taille + ", cheveux=" + cheveux + ", yeux=" + yeux + ", caractere=" + caractere + ", statut=" + statut + ", cuisine=" + cuisine + '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCorpulence() {
        return corpulence;
    }

    public void setCorpulence(String corpulence) {
        this.corpulence = corpulence;
    }

    public String getPilosite() {
        return pilosite;
    }

    public void setPilosite(String pilosite) {
        this.pilosite = pilosite;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAlcool() {
        return alcool;
    }

    public void setAlcool(String alcool) {
        this.alcool = alcool;
    }

    public String getTabac() {
        return tabac;
    }

    public void setTabac(String tabac) {
        this.tabac = tabac;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getCheveux() {
        return cheveux;
    }

    public void setCheveux(String cheveux) {
        this.cheveux = cheveux;
    }

    public String getYeux() {
        return yeux;
    }

    public void setYeux(String yeux) {
        this.yeux = yeux;
    }

    public String getCaractere() {
        return caractere;
    }

    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Caracteristique(int ID, String corpulence, String pilosite, String origine, String profession, String alcool, String tabac, String taille, String cheveux, String yeux, String caractere, String statut, String cuisine) {
        this.ID = ID;
        this.corpulence = corpulence;
        this.pilosite = pilosite;
        this.origine = origine;
        this.profession = profession;
        this.alcool = alcool;
        this.tabac = tabac;
        this.taille = taille;
        this.cheveux = cheveux;
        this.yeux = yeux;
        this.caractere = caractere;
        this.statut = statut;
        this.cuisine = cuisine;
    }
    
}
