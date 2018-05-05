/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Matching;

import Entities.Matching.Packaging;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nadia
 */
public class ServicePackaging {
    
    
    public ArrayList<Packaging> getList2() {
        ArrayList<Packaging> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulMate-Symphony/web/app_dev.php/Client/FO_voirpackagingM");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> packagings = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(packagings);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) packagings.get("root");
                    
                    for (Map<String, Object> obj : list) {
                        Packaging task = new Packaging();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setID((int) id);
                        task.setNom(obj.get("nom").toString());
                        task.setContenu( (int) obj.get("contenu") );
                        task.setDuree((int) obj.get("duree"));
                        task.setPrix((float) obj.get("prix"));
                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

    
}
