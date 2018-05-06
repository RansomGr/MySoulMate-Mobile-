/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.User;

import Entities.User.User;
import InternalAPI.CustomEspritJSONParser;
import Views.User.ForgotView;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.List;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Ransom
 */
public class ServiceUser implements Service.Service {

    @Override
    public void create(Object o) {
        /*private int id;
    private String nom;
    private String prenom;
    private String gender;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private int enabled;
    private String salt;
    private String password;
    private String last_login;
    private String confirmation_token;
    private String role;*/
        User a=(User)o;
          con.setUrl(url+
                  "User/addnew?nom="+a.getNom()+
                  "&prenom="+a.getPrenom()+
                  "&gender="+a.getGender()+
                  "&username="+a.getUsername()+
                  "&email="+a.getEmail()+
                  "&password="+a.getPassword()
                  
          );
          con.addResponseListener((NetworkEvent evt) -> {
              String str = new String(con.getResponseData());
              System.out.println(str);
          });
          NetworkManager.getInstance().addToQueueAndWait(con);
           

     
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
    public void checkEmail(String email)
    {   
        con.setPost(false);
        
        //https://api.trumail.io/v1/JSON/drom@ferg
        if(!email.equals("")&&email!=null)
        {
            
            System.out.println("email: "+email);
        con.setUrl("http://api.trumail.io/v1/JSON/"+email);
          con.addResponseListener((NetworkEvent evt) -> {
                String data = new String(con.getResponseData());
         JSONParser jsonp = new JSONParser();
             try {
                 Map<String, Object> Results = jsonp.parseJSON(new CharArrayReader(data.toCharArray()));
                 if(Results.get("hostExists").equals("true"))
                 ForgotView.reply(true);
                 else
                  ForgotView.reply(false);   
                 } catch (IOException ex) {
              
             }
         });
        NetworkManager.getInstance().addToQueueAndWait(con);  
        }
        else
        ForgotView.reply(false);
    }
    public void sendEmailRecovery(String email)
    {     
         con.setUrl(url+"User/recover?email="+email);
         con.addResponseListener((NetworkEvent evt) -> {
         });
         NetworkManager.getInstance().addToQueueAndWait(con);   
    }
    public void fetchOneByCredentials(String login,String password)
    {
        User Utilisateur= new User();
        con.setUrl(url+"User?login="+login+"&password="+password);
        con.addResponseListener((NetworkEvent evt) -> {
             String str = new String(con.getResponseData());
             JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> Users = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                if((int)Float.parseFloat(Users.get("id").toString())!=-1){// getting the user if found -1 not found 
                   Utilisateur.setId((int)Float.parseFloat(Users.get("id").toString()));
                Utilisateur.setNom(Users.get("nom").toString());
                Utilisateur.setPrenom(Users.get("prenom").toString());
                Utilisateur.setGender(Users.get("gender").toString());
                CustomEspritJSONParser cejp = new CustomEspritJSONParser(Users.get("datenaissance").toString());      
                String x=cejp.getNestedItems().get("timestamp").toString();  
                Utilisateur.setDatenaissance(new Date((long)Float.parseFloat(x)*1000));   
                MyApplication.setConnectedUser(Utilisateur);
                }
                else
                MyApplication.setConnectedUser(null);        
                } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);   
    }
 
    
}
