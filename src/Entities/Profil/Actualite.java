/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Profil;

import Entities.User.User;

/**
 *
 * @author Sofiene
 */
public class Actualite {

    private int id;
    private String photo;
    private String contenu;
    private String username;
    private String dateAdd;
    private User Createur;
    public Actualite() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public User getCreateur() {
        return Createur;
    }

    public void setCreateur(User Createur) {
        this.Createur = Createur;
    }
          
    
    
    
    
    
    
    
    
    
}
