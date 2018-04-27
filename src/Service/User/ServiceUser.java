/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.User;

import Entities.User.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.List;

import java.io.IOException;
import java.util.Map;
/**
 *
 * @author Ransom
 */
public class ServiceUser implements Service.Service {

    @Override
    public void create(Object o) {
     
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void remove(Object o) {
     
    }

    @Override
    public List<? extends Object> fetchAll() {
   return null;
    }

    @Override
    public Object fetchOneById() {
    return null;
    }
    public User fetchOneByCredentials(String login,String password)
    {
        User Utitlisateur=new User();
        con.setUrl(url+"User?login="+login+"&password="+password);
        con.addResponseListener((NetworkEvent evt) -> {
             String str = new String(con.getResponseData());
              System.out.println(str);
             JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> Users = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println(Users);
                Utitlisateur.setId((int)Float.parseFloat(Users.get("id").toString()));                     
                } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return Utitlisateur;
    }
 
    
}
