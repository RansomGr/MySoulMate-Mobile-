/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Matching;

import Entities.Matching.Caracteristique;
import Service.Service;
import static Service.Service.con;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Nadia
 */
public class ServicePref implements Service<Caracteristique> {
    
     
    

    @Override
    public void create(Caracteristique o) {
         
        Caracteristique a=(Caracteristique)o;
          con.setUrl("http://localhost/MySoulMate-Symphony/web/app_dev.php"+
                  "/Client/FO_ajouterPrefM?corpulence="+a.getCorpulence()+
                  "&pilosite="+a.getPilosite()+
                  "&origine="+a.getOrigine()+
                  "&profession="+a.getProfession()+
                  "&alcool="+a.getAlcool()+
                  "&tabac="+a.getTabac()+
                  "&taille="+a.getTaille()+
                  "&cheveux="+a.getCheveux()+
                  "&yeux="+a.getYeux()+
                  "&caractere="+a.getCaractere()+
                  "&cuisine="+a.getCuisine()+
                  "&statut="+a.getStatut()
                  
          );
          
          
          con.addResponseListener((NetworkEvent evt) -> {
              String str = new String(con.getResponseData());
              System.out.println(str);
          });
          NetworkManager.getInstance().addToQueueAndWait(con);
           
    }

    @Override
    public void update(Caracteristique o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Caracteristique o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public java.util.List<Caracteristique> fetchAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object fetchOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
