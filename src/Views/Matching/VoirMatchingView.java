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
    private com.codename1.ui.Label gui_titre1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_titre2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Button gui_VoirPackaging_btn = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_AjoutPref_btn = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_VoirAmis_btn = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("VoirMatchingView");
        setName("VoirMatchingView");
        addComponent(gui_titre1);
        addComponent(gui_titre2);
        addComponent(gui_Container);
        addComponent(gui_VoirPackaging_btn);
        addComponent(gui_AjoutPref_btn);
        addComponent(gui_VoirAmis_btn);
        gui_titre1.setPreferredSizeStr("43.24161mm inherit");
        gui_titre1.setText("RETROUVEZ L'AMOUR");
                gui_titre1.setInlineStylesTheme(resourceObjectInstance);
        gui_titre1.setInlineAllStyles("font:4.0mm native:MainBold native:MainBold;");
        gui_titre1.setName("titre1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_titre1.getParent().getLayout()).setInsets(gui_titre1, "19.653479% 24.184488% auto 18.158527%").setReferenceComponents(gui_titre1, "-1 -1 -1 -1").setReferencePositions(gui_titre1, "0.0 0.0 0.0 0.0");
        gui_titre2.setPreferredSizeStr("42.636833mm 5.7453885mm");
        gui_titre2.setText("DE VOTRE VIE!");
                gui_titre2.setInlineStylesTheme(resourceObjectInstance);
        gui_titre2.setInlineAllStyles("font:5.0mm native:MainBold native:MainBold;");
        gui_titre2.setName("titre2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_titre2.getParent().getLayout()).setInsets(gui_titre2, "0.0mm 0.0mm auto 28.608923%").setReferenceComponents(gui_titre2, "0 0 -1 -1").setReferencePositions(gui_titre2, "1.0 0.0 0.0 0.0");
        gui_Container.setPreferredSizeStr("111.88389mm 62.140915mm");
        gui_Container.setUIID("Matchings_container");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)111.88389);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)62.140915);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "32.802124% 4.8382187mm 12.616201% 3.7798615mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        gui_VoirPackaging_btn.setText("Voir plus de compatibilit\u00E9");
                gui_VoirPackaging_btn.setInlineStylesTheme(resourceObjectInstance);
        gui_VoirPackaging_btn.setName("VoirPackaging_btn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_VoirPackaging_btn,"\ue87e".charAt(0));
        ((com.codename1.ui.layouts.LayeredLayout)gui_VoirPackaging_btn.getParent().getLayout()).setInsets(gui_VoirPackaging_btn, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_VoirPackaging_btn, "4 0 -1 -1").setReferencePositions(gui_VoirPackaging_btn, "1.0 0.0 0.0 0.0");
        gui_AjoutPref_btn.setText("Ajouter mes pr\u00E9f\u00E9rences");
                gui_AjoutPref_btn.setInlineStylesTheme(resourceObjectInstance);
        gui_AjoutPref_btn.setName("AjoutPref_btn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_AjoutPref_btn,"\ue87d".charAt(0));
        ((com.codename1.ui.layouts.LayeredLayout)gui_AjoutPref_btn.getParent().getLayout()).setInsets(gui_AjoutPref_btn, "2.1167226mm 0.0mm auto auto").setReferenceComponents(gui_AjoutPref_btn, "-1 0 -1 -1").setReferencePositions(gui_AjoutPref_btn, "0.0 0.0 0.0 0.0");
        gui_VoirAmis_btn.setText("Voir mes amis");
                gui_VoirAmis_btn.setInlineStylesTheme(resourceObjectInstance);
        gui_VoirAmis_btn.setName("VoirAmis_btn");
        ((com.codename1.ui.layouts.LayeredLayout)gui_VoirAmis_btn.getParent().getLayout()).setInsets(gui_VoirAmis_btn, "auto 33.864544% 0.0mm auto").setReferenceComponents(gui_VoirAmis_btn, "-1 -1 -1 -1").setReferencePositions(gui_VoirAmis_btn, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
