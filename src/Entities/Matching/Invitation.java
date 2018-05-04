/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Matching;

import Entities.User.User;

/**
 *
 * @author Nadia
 */
public class Invitation {
    
     private User client1;
    private User client2;
    private String statut;

    public Invitation(User client1, User client2, String statut ) {
        this.client1 = client1;
        this.client2 = client2;
        this.statut = statut;
    }

    public User getClient1() {
        return client1;
    }

    public void setClient1(User client1) {
        this.client1 = client1;
    }

    public User getClient2() {
        return client2;
    }

    public void setClient2(User client2) {
        this.client2 = client2;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

 


    @Override
    public String toString() {
        return "Invitation{" + "client1=" + client1 + ", client2=" + client2 + ", statut=" + statut +  '}';
    }
    
}
