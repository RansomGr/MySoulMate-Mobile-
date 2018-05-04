/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Profil;

import Entities.Matching.Caracteristique;

/**
 *
 * @author Nadia
 */
public class Profil {
      private int id;
  
   private  Caracteristique Caracteristique;
   private String photo;
   private String description;	
   private Caracteristique preference;

   



    public Profil(int id,Caracteristique Caracteristique, String photo, String description, Caracteristique preference) {
        this.id = id;
       
        this.Caracteristique = Caracteristique;
        this.photo = photo;
        this.description = description;
        this.preference = preference;
    }

    public Profil(Caracteristique Caracteristique, String photo, String description) {
       this.Caracteristique = Caracteristique;
        this.photo = photo;
        this.description = description;
    }

    public Profil() {
       photo="no_PROF";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public Caracteristique getCaracteristique() {
        return Caracteristique;
    }

    public void setCaracteristique(Caracteristique Caracteristique) {
        this.Caracteristique = Caracteristique;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Caracteristique getPreference() {
        return preference;
    }

    public void setPreference(Caracteristique preference) {
        this.preference = preference;
    }
    
}
