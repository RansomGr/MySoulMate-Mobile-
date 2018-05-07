/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Matching;

import Entities.Profil.Caracteristique;
import Entities.Profil.Profil;
import Entities.User.Adresse;
import Entities.User.User;
import InternalAPI.CustomEspritJSONParser;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nadia
 */
public class ServiceMatching {

    public List<User> getList2() {
        List<User> Usersss = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setPost(false);
        con.setUrl("http://localhost/MySoulMate-Symphony/web/app_dev.php/Client/FO_matching_homepageM" + MyApplication.getConnectedUser().getId());
        //System.out.println("Hellooooo"+MyApplication.getConnectedUser().getId());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> Users = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String, Object> User : Users) {
                        User Utilisateur = new User();
                        Utilisateur.setId((int) Float.parseFloat(User.get("id").toString()));
                        Utilisateur.setNom(User.get("nom").toString());
                        Utilisateur.setPrenom(User.get("prenom").toString());
                        Utilisateur.setGender(User.get("gender").toString());
                        Utilisateur.setUsername(User.get("username").toString());
                        Utilisateur.setId((int) Float.parseFloat(User.get("matchtot").toString()));
                        CustomEspritJSONParser cejp = new CustomEspritJSONParser(User.get("datenaissance").toString());
                        String x = cejp.getNestedItems().get("timestamp").toString();
                        Utilisateur.setDatenaissance(new Date((long) Float.parseFloat(x) * 1000));
                        cejp = new CustomEspritJSONParser(User.get("profil").toString());
                        Map<String, Object> Profil = cejp.getNestedItems();
                        cejp = new CustomEspritJSONParser(Profil.get("caracteristique").toString());
                        Map<String, Object> Caracteristique = cejp.getNestedItems();
                        cejp = new CustomEspritJSONParser(Profil.get("preference").toString());
                        Map<String, Object> Preference = cejp.getNestedItems();
                        Caracteristique C = new Caracteristique(
                                (int) Float.parseFloat(Caracteristique.get("id").toString()),
                                Caracteristique.get("corpulence").toString(),
                                Caracteristique.get("pilosite").toString(),
                                Caracteristique.get("origine").toString(),
                                Caracteristique.get("profession").toString(),
                                Caracteristique.get("alcool").toString(),
                                Caracteristique.get("tabac").toString(),
                                Caracteristique.get("taille").toString(),
                                Caracteristique.get("cheveux").toString(),
                                Caracteristique.get("yeux").toString(),
                                Caracteristique.get("caractere").toString(),
                                Caracteristique.get("statut").toString(),
                                Caracteristique.get("cuisine").toString());

                        Caracteristique pref = new Caracteristique(
                                (int) Float.parseFloat(Preference.get("id").toString()),
                                Preference.get("corpulence").toString(),
                                Preference.get("pilosite").toString(),
                                Preference.get("origine").toString(),
                                Preference.get("profession").toString(),
                                Preference.get("alcool").toString(),
                                Preference.get("tabac").toString(),
                                Preference.get("taille").toString(),
                                Preference.get("cheveux").toString(),
                                Preference.get("yeux").toString(),
                                Preference.get("caractere").toString(),
                                Preference.get("statut").toString(),
                                Preference.get("cuisine").toString());
                        Profil p = new Profil(
                                (int) Float.parseFloat(Profil.get("id").toString()),
                                C, Profil.get("photo").toString(),
                                Profil.get("description").toString(),
                                pref);
                        Utilisateur.setProfil(p);
                        Usersss.add(Utilisateur);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return Usersss;
    }

    public void Inviter(int id_u) {

        con.setUrl(url+ "Client/FO_inviterM" + id_u + "/" + MyApplication.getConnectedUser().getId());

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
