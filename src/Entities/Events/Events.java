/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Events;

import java.io.Serializable;
import java.util.Date;
//import java.util.Objects;

/**
 *
 * @author dellpro
 */
public class Events implements Serializable{
    private int id;
    private String nomEvt;
    private Date dateEvt;
    private String heure;
    private String dureeEvt;
    private String typeEvt;
    private String descriptionEvt;
    private int nbMax;
    private int planEvt;   
    private int organisateurEvt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEvt() {
        return nomEvt;
    }

    public void setNomEvt(String nomEvt) {
        this.nomEvt = nomEvt;
    }

    public Date getDateEvt() {
        return dateEvt;
    }

    public void setDateEvt(Date dateEvt) {
        this.dateEvt = dateEvt;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDureeEvt() {
        return dureeEvt;
    }

    public void setDureeEvt(String dureeEvt) {
        this.dureeEvt = dureeEvt;
    }

    public String getTypeEvt() {
        return typeEvt;
    }

    public void setTypeEvt(String typeEvt) {
        this.typeEvt = typeEvt;
    }

    public String getDescriptionEvt() {
        return descriptionEvt;
    }

    public void setDescriptionEvt(String descriptionEvt) {
        this.descriptionEvt = descriptionEvt;
    }

    public int getNbMax() {
        return nbMax;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }

    public int getPlanEvt() {
        return planEvt;
    }

    public void setPlanEvt(int planEvt) {
        this.planEvt = planEvt;
    }

    public int getOrganisateurEvt() {
        return organisateurEvt;
    }

    public void setOrganisateurEvt(int organisateurEvt) {
        this.organisateurEvt = organisateurEvt;
    }

    public Events(int id, String nomEvt, Date dateEvt, String heure, String dureeEvt, String typeEvt, String descriptionEvt, int nbMax, int planEvt, int organisateurEvt) {
        this.id = id;
        this.nomEvt = nomEvt;
        this.dateEvt = dateEvt;
        this.heure = heure;
        this.dureeEvt = dureeEvt;
        this.typeEvt = typeEvt;
        this.descriptionEvt = descriptionEvt;
        this.nbMax = nbMax;
        this.planEvt = planEvt;
        this.organisateurEvt = organisateurEvt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Events other = (Events) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nbMax != other.nbMax) {
            return false;
        }
        if (this.planEvt != other.planEvt) {
            return false;
        }
        if (this.organisateurEvt != other.organisateurEvt) {
            return false;
        }
//        if (!Objects.equals(this.nomEvt, other.nomEvt)) {
//            return false;
//        }
//        if (!Objects.equals(this.heure, other.heure)) {
//            return false;
//        }
//        if (!Objects.equals(this.dureeEvt, other.dureeEvt)) {
//            return false;
//        }
//        if (!Objects.equals(this.typeEvt, other.typeEvt)) {
//            return false;
//        }
//        if (!Objects.equals(this.descriptionEvt, other.descriptionEvt)) {
//            return false;
//        }
//        if (!Objects.equals(this.dateEvt, other.dateEvt)) {
//            return false;
//        }
        return true;
    }

    public Events(int id) {
        this.id = id;
    }

    public Events() {
    }

     @Override
    public String toString() {
        return "Events{" + "id=" + id + '}';
    }   
    
}
