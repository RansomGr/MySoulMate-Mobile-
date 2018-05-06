/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Profil;


import Entities.Profil.Caracteristique;
import Service.Service;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sofiene
 */



public class CaracteristiqueService implements Service<Caracteristique>{


    public ArrayList<Caracteristique> ParseCaracteristique(String json) {
        
        ArrayList<Caracteristique> caracteristiques = new ArrayList<>();
        
          try {
                
            JSONParser j = new JSONParser();
            Map<String, Object> carac = j.parseJSON(new CharArrayReader(json.toCharArray()));
            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) carac.get("root");
            
            for (Map<String, Object> obj : list) {
                Caracteristique c = new Caracteristique();
                c.setAlcool(obj.get("alcool").toString());
                c.setCaractere(obj.get("caractere").toString());
                c.setCheveux(obj.get("cheveux").toString());
                c.setCorpulence(obj.get("corpulence").toString());
                c.setCuisine(obj.get("cuisine").toString());
              //  c.setId(Math.round(Float.parseFloat(obj.get("id").toString())));
                c.setOrigine(obj.get("origine").toString());
                c.setPilosite(obj.get("pilosite").toString());
                c.setProfession(obj.get("profession").toString());
                c.setStatut(obj.get("status").toString());
                c.setTabac(obj.get("tabac").toString());
                c.setTaille(obj.get("taille").toString());
                c.setYeux(obj.get("yeux").toString());
                caracteristiques.add(c);
         
            }

            } catch (IOException ex) {System.out.println(ex.getMessage());}  
   
        return caracteristiques;
    }
    
    
    
    
    
    
    
  
    
    
    @Override
    public void create(Caracteristique t) {
        
    }

    @Override
    public void update(Caracteristique t) {
      
    }

    @Override
    public void remove(Caracteristique t) {
     
    }

   

    @Override
    public Caracteristique fetchOneById(int id) {
      return null;
    }

    @Override
    public List<Caracteristique> fetchAll() {
     return null ;
    }
    
    
    
    
    
}
