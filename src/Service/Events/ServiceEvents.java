/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Events;

import Entities.Events.Events;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dellpro
 */
public class ServiceEvents {
    String message;
    String responsee = new String("");
    Boolean success;
    ConnectionRequest cr;
    String url = "http://127.0.0.1/MobileSoulmate/web/app_dev.php/api/event";
    ArrayList<Events> listEvents = new ArrayList<>();

    
    public ArrayList<Events> getListClubCherche(String category) {
        cr = new ConnectionRequest();
        cr.setPost(false);        
        cr.setUrl(url + "/allevents");
        cr.addArgument("category", category);       
        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                listEvents = getJSONListEvent(new String(cr.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(cr);
        return listEvents;
    }
    
       public ArrayList<Events> getJSONListEvent(String json) {
        ArrayList<Events> listUsers = new ArrayList<>();
        try {
            System.out.println(json);
            JSONParser j = new JSONParser();
            Map<String, Object> colocations = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) colocations.get("root");
           System.out.println(list);
            for (Map<String, Object> obj : list) {
                
                
               Events evt = new Events(
                  (int) (double) obj.get("id"),                    
                    obj.get("nomEvt").toString(),
//                    (Date) obj.get("dateEvt"),
                       new Date(),
                     obj.get("heure").toString(),
                    obj.get("dureeEvt").toString(),
                    obj.get("typeEvt").toString(),
                       obj.get("decriptionEvt").toString(),
                       (int) (double) obj.get("nbMax"),
                       (int) (double) obj.get("planEvt"),
                        (int) (double) obj.get("organisateurEvt")
                    );
            
//            evt.setDateEvt((Date) obj.get("dateEvt"));
//            evt.setDescriptionEvt(obj.get("description").toString());
//            evt.setTypeEvt(obj.get("category").toString());
//            evt.setOrganisateurEvt((int) (double)obj.get("organisateurEvt"));
                        
                listEvents.add(evt);
            }
        } catch (IOException ex) {
        }
        return listEvents;

    }
       
       public ArrayList<Events> getListEvt() {
        cr = new ConnectionRequest();
        cr.setUrl(url + "/allevents");
        cr.setPost(false);
        
        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                listEvents = getJSONListEvent(new String(cr.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(cr);
        
        return listEvents;
    }
       
 //      public boolean ajoutEvent(Events evt) {

//        success = false;
//        cr = new ConnectionRequest(url + "/ajout");
//        cr.setPost(false);
//        cr.addArgument("titre", pub.getTitre());
//        cr.addArgument("description", pub.getDescription());
//        cr.addArgument("image", pub.getImage());
//        cr.addArgument("iduser", pub.getUserid().getId()+"");
//       
//        //cr.addArgument("photo","default0d.jpg");
//        
//     
//        
//        cr.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                try {
//                    message = new String(cr.getResponseData(), "UTF-8");
//                    System.out.println("messageValue: " + message);
//                    if (message.equals("done")) {
//                        success = true;
//                    }
//                } catch (UnsupportedEncodingException ex) {
//                    System.out.println("failed");
//                }
//
//            }
//        });
//        NetworkManager.getInstance().addToQueue(cr);
//        System.out.println("successValue    :" + success);
//        return success;
//    }
//     public boolean modifEvent(Events evt) {
//
//        success = false;
//        cr = new ConnectionRequest(url + "/modifier");
//        cr.setPost(false);
//        cr.addArgument("titre", pub.getTitre());
//        cr.addArgument("description", pub.getDescription());
//        
//        cr.addArgument("id", pub.getId()+"");
//       
//        //cr.addArgument("photo","default0d.jpg");
//        
//     
//        
//        cr.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                try {
//                    message = new String(cr.getResponseData(), "UTF-8");
//                    System.out.println("messageValue: " + message);
//                    if (message.equals("done")) {
//                        success = true;
//                    }
//                } catch (UnsupportedEncodingException ex) {
//                    System.out.println("failed");
//                }
//
//            }
//        });
//        NetworkManager.getInstance().addToQueue(cr);
//        System.out.println("successValue    :" + success);
//        return success;
 //  }
    
}
