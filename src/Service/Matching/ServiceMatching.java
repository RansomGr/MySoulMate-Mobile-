/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Matching;

import Entities.User.Adresse;
import Entities.User.User;
import Service.Service;
import static Service.Service.con;
import static Service.Service.url;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nadia
 */
public class ServiceMatching  {

    public ArrayList<User> getList2() {
        ArrayList<User> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://localhost/MySoulMate-Symphony/web/app_dev.php/Client/FO_matching_homepageM"+MyApplication.getConnectedUser().getId());
        System.out.println("Hellooooo"+MyApplication.getConnectedUser().getId());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    
                    for (Map<String, Object> obj : list) {
                        User task = new User();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float matchtot = Float.parseFloat(obj.get("matchtot").toString());
                        
                        task.setId((int) id);
                        task.setUsername(obj.get("username").toString());
                        task.setMatchtot((int) matchtot);
                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    

    public void Inviter(User a) {

        con.setUrl(url
                + "/Client/FO_inviterM{" + a.getId() + "}"
        );

        con.addResponseListener((NetworkEvent evt) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    public void AccepterInvit(User a) {

        con.setUrl(url
                + "/Client/FO_AccepterInvitM{" + a.getId() + "}"
        );

        con.addResponseListener((NetworkEvent evt) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void SuppInvit(User a) {

        con.setUrl(url
                + "/Client/FO_SuppInvitM{" + a.getId() + "}"
        );

        con.addResponseListener((NetworkEvent evt) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }


}
