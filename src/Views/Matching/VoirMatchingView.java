/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Matching;

import Entities.User.User;
import Service.Matching.ServiceMatching;
import Service.Matching.ServicePackaging;
import Views.TerminalView;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.mycompany.myapp.MyApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nadia
 */
public class VoirMatchingView extends com.codename1.ui.Form implements TerminalView {

    ServiceMatching service = new ServiceMatching();
    List<User> matchings = new ArrayList<>();
    SpanLabel lb;

    public VoirMatchingView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_form();
    }

    public VoirMatchingView(com.codename1.ui.util.Resources resourceObjectInstance) {

        init_form();
    }

    @Override
    public void init_form() {
        TerminalView.super.init_form();
        this.setLayout(BoxLayout.y());
        TextModeLayout tm = new TextModeLayout(4, 2);

        lb = new SpanLabel("");
        this.add(lb);
        service = new ServiceMatching();
        matchings = service.getList2();
        if (matchings != null && !matchings.isEmpty()) {
            initi();
        }

    }

    private void initi() {
        int mm = Display.getInstance().convertToPixels(3);
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);
this.setLayout(BoxLayout.x());
        this.setLayout(BoxLayout.y());
        
        ArrayList<Map<String, Object>> data = new ArrayList<>();

        for (int i= 0; i < matchings.size(); i++) {
            
          //  for (int x = 0; x < 2; x++) {

            String filePath = "http://localhost/MySoulMate-Symphony/web/images/" + matchings.get(i).getProfil().getPhoto();

            if (filePath != null) {
                try {

                    Image im = URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(150, 150, 0xffff0000), false), filePath,
                            filePath);
                    this.add(new Label(im));
                    this.add(new Label(matchings.get(i).getUsername()));
                    this.add(new Label( matchings.get(i).getMatchtot()+" %"));
                    System.out.println(matchings.get(i).getMatchtot());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

              Button bouton = new Button("Inviter");
              this.add(bouton);
              int id=matchings.get(i).getId();
              bouton.addActionListener(e -> {
                  ServiceMatching servicem = new ServiceMatching();
                 servicem.Inviter(id);
              });
            DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
            MultiList ml = new MultiList(model);

            //this.add(BorderLayout.CENTER, ml);
            ml.addActionListener((ActionListener) (ActionEvent evt) -> {

                //service.Inviter(matchings.get(ml.getSelectedIndex()));

                Button showNotification = new Button("Notification");
                showNotification.addActionListener(e -> ToastBar.showMessage("Invitation envoyée!", FontImage.MATERIAL_INFO));
                this.add(showNotification);

            });

        }
    //}
            Button bouton1 = new Button("Voir plus de compatibilite");
            this.add(bouton1);
            bouton1.addActionListener(e -> {
                ServicePackaging servicep = new ServicePackaging() ;
                servicep.getList2();
                MyApplication.setCurrentView(new PackView(MyApplication.getTheme()));
                 
              });
        DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
    }
   

    private Map<String, Object> createListEntry(Image icon, String username, int matchtot) {
        Map<String, Object> entry = new HashMap<>();

        entry.put("Line1", icon);
        entry.put("Line2", username);
        entry.put("Line3", matchtot);
        return entry;
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("VoirMatchingView");
        setName("VoirMatchingView");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
