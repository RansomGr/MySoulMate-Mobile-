/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.User;

/**
 *
 * @author Nadia
 */
public class Adresse {
    
    
private int ID;
private int numero;
private String gouvernorat ;
private int code_postal;
private String ville;

    
    public Adresse(int ID, int numero, String gouvernorat, int code_postal, String ville) {
        this.ID = ID;
        this.numero = numero;
        this.gouvernorat = gouvernorat;
        this.code_postal = code_postal;
        this.ville = ville;
    }

    public Adresse(int numero, String gouvernorat, int code_postal, String ville) {
      //  this.ID = -1;
        this.numero = numero;
        this.gouvernorat = gouvernorat;
        this.code_postal = code_postal;
        this.ville = ville;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    
    
}
