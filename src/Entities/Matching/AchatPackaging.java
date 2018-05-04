/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Matching;

import Entities.User.User;
import java.util.Date;

/**
 *
 * @author Nadia
 */
public class AchatPackaging {
    
    private int ID;
    private User c;
    private Packaging p;
    private Date date_debut;

    public AchatPackaging(User c, Packaging p, Date date_debut) {
        this.c = c;
        this.p = p;
        this.date_debut = date_debut;
    }
    
        public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public User getC() {
        return c;
    }

    public void setC(User c) {
        this.c = c;
    }

    public Packaging getP() {
        return p;
    }

    public void setP(Packaging p) {
        this.p = p;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_fin) {
        this.date_debut = date_fin;
    }

    @Override
    public String toString() {
        return "Achat_packaging{" + "c=" + c + ", p=" + p + ", date_debut=" + date_debut + '}';
    }

    
}
