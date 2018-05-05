/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Matching;

import Entities.User.User;
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
public class ServiceMatching {
    

    public ArrayList<User> getList2() {
        ArrayList<User> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulMate-Symphony/web/app_dev.php/Client/FO_matching_homepageM");
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
                        User task = new User();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                        task.setPrenom(obj.get("nom").toString());
                        task.setAdresse( (int) obj.get("adresse") );
                        task.setMatchtot((int) obj.get("matchtot"));
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
