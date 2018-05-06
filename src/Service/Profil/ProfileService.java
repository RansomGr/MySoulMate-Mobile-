/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Profil;


import Entities.Profil.Profil;
import Service.Service;
import Utils.Constants;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sofiene
 */
public class ProfileService implements Service<Profil>{

 /*   public ArrayList<Profile> ParseProfile(String json){
          
            ArrayList<Profile> profil = new ArrayList<>();  
         
                 
            try {
                
            JSONParser j = new JSONParser();
            Map<String, Object> commodites = j.parseJSON(new CharArrayReader(json.toCharArray()));
            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) commodites.get("root");
            
            for (Map<String, Object> obj : list) {
              Profile p = new Profile();              
              p.setDescription(obj.get("description").toString());
              p.setEmail(obj.get("email").toString());
              p.setGender(obj.get("gender").toString());
              p.setIdCaracteristique(Math.round(Float.parseFloat(obj.get("idCaracteristique").toString())));
              p.setIdProfile(Math.round(Float.parseFloat(obj.get("idProfile").toString())));
              p.setNom(obj.get("nom").toString());
              p.setPhoto(obj.get("photo").toString());
              p.setPrenom(obj.get("prenom").toString());
              p.setUsername(obj.get("username").toString());              
              profil.add(p);
              
            }
            
            } catch (IOException ex) {System.out.println(ex.getMessage());}  
             
           
     
         
         return profil;
       
    }
   //  @Override
     /*public List<Profil> fetchAll() {
        
            List<Profil> profil = new ArrayList<>();  
            ConnectionRequest req = new ConnectionRequest();
            req.setUrl(Constants.GET_PROFILE+"?idUser="+1);    
            req.addResponseListener((NetworkEvent evt) -> {
                 
            try {
                
            JSONParser j = new JSONParser();
            Map<String, Object> commodites = j.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) commodites.get("root");
            
            for (Map<String, Object> obj : list) {
              Profil p = new Profil();              
              p.setDescription(obj.get("description").toString());
              p.setEmail(obj.get("email").toString());
              p.setGender(obj.get("gender").toString());
              p.setIdCaracteristique(Math.round(Float.parseFloat(obj.get("idCaracteristique").toString())));
              p.setIdProfile(Math.round(Float.parseFloat(obj.get("idProfile").toString())));
              p.setNom(obj.get("nom").toString());
              p.setPhoto(obj.get("photo").toString());
              p.setPrenom(obj.get("prenom").toString());
              p.setUsername(obj.get("username").toString());              
              profil.add(p);
              
            }
            
            } catch (IOException ex) {System.out.println(ex.getMessage());}  
             
            });
     
          NetworkManager.getInstance().addToQueue(req);
         
         return profil;
       
    }
*/

    @Override
    public void create(Profil o) {
     
    }

    @Override
    public void update(Profil o) {

    }

    @Override
    public void remove(Profil o) {
    
    }

    @Override
    public List<Profil> fetchAll() {
     return null;
    }

    @Override
    public Object fetchOneById(int id) {
return null;
    }
    
}
