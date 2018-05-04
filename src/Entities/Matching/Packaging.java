/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Matching;

/**
 *
 * @author Nadia
 */
public class Packaging {
    
    private int ID;
    private String nom;
    private int contenu;
    private int duree ;
    private float prix ;

        public Packaging( )
        {
        
        }
        
    public Packaging( String nom, int contenu, int duree, float prix) {
        //this.ID = -1;
        this.nom = nom;
        this.contenu = contenu;
        this.duree = duree;
        this.prix = prix;
    }
    
    
    public Packaging(int ID, String nom, int contenu, int duree, float prix) {
        this.ID = ID;
        this.nom = nom;
        this.contenu = contenu;
        this.duree = duree;
        this.prix = prix;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getContenu() {
        return contenu;
    }

    public void setContenu(int contenu) {
        this.contenu = contenu;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Packaging{" + "ID=" + ID + ", nom=" + nom + ", contenu=" + contenu + ", duree=" + duree + ", prix=" + prix + '}';
    }
    
}
