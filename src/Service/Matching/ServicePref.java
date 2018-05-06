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
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Nadia
 */
public class ServicePref implements Service {
    
        @Override
    public void create(Object o) {
       
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
    
    
   public java.util.List<Template> fetchAll(){return null;}
   public Object fetchOneById(int id){return null;}
   public static String getUrl(){return Service.url;}
    
        @Override
    public void update(Object o) {

    }

    @Override
    public void remove(Object o) {
     
    }
}
