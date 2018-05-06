/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Profil;

import Entities.Profil.Actualite;
import Service.Service;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sofiene
 */
public class ActualiteService implements Service<Actualite>{

    
     public ArrayList<Actualite> ParseActualite(String json) {
         
        ArrayList<Actualite> actualites = new ArrayList<>(); 
          try {
                
            JSONParser j = new JSONParser();
            Map<String, Object> carac = j.parseJSON(new CharArrayReader(json.toCharArray()));
            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) carac.get("root");
            
            for (Map<String, Object> obj : list) {
                
                   Actualite actualite = new Actualite();                
                   actualite.setContenu(obj.get("contenu").toString());
                   actualite.setDateAdd(obj.get("dateAdd").toString());
                   actualite.setId(Math.round(Float.parseFloat(obj.get("id").toString())));
                   actualite.setPhoto(obj.get("photo").toString());
                   actualite.setUsername(obj.get("username").toString());
                   actualites.add(actualite);
                   actualite.setCreateur(MyApplication.getConnectedUser());
 
            }

            } catch (IOException ex) {System.out.println(ex.getMessage());}     
        return actualites;
    }
    
    
    

    
    
    @Override
    public void create(Actualite t) {
    }

    @Override
    public void update(Actualite t) {
     
    }

    @Override
    public void remove(Actualite t) {
        
    }

    @Override
    public Actualite fetchOneById(int id) {
      return null;
    }

    @Override
    public List<Actualite> fetchAll() {
    return null;
    }
    
}
