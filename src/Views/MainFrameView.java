/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Profil.Actualite;
import Service.Profil.ActualiteService;
import Utils.Constants;
import Views.Matching.VoirMatchingView;
import Views.Plan.ListPlanView;
import Views.Profil.AddActualiteForm;
import Views.Profil.DetailsActualiteForm;
import Views.Profil.HoroscopeForm;
import Views.Profil.ProfileForm;
import Views.User.UserAccountView;
import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author Ransom
 */

public class MainFrameView extends com.codename1.ui.Form {
    private Button profilePicButton;
    private Button Settings;
    private Toolbar tb;
    private List<Form>Navigation ;
    public MainFrameView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_MainFrameView();
    }

    public MainFrameView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_MainFrameView();
    }
       private void init_MainFrameView()
    {
        tb=this.getToolbar();    
        Image profilePic =  URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(150, 150, 0xffff0000), false),MyApplication.getConnectedUser().getProfil().getPhoto(),
        Constants.IMAGE_PROFILE_URL+MyApplication.getConnectedUser().getProfil().getPhoto());
        profilePic = profilePic.scaled(80, 80);
        Image  icon = MyApplication.getTheme().getImage("settings.png"); 
        icon=  icon.scaled(48, 48);
        Settings= new Button(icon);
        Settings.addActionListener((evt) -> {  
        MyApplication.enableTollBar(false);
        MyApplication.setCurrentView(this.renderTerminalView(UserAccountView.class));
        });
        Label label1 = new Label(profilePic);
        int w = profilePic.getWidth();
        int h = profilePic.getHeight();
        Image maskImage = Image.createImage(w, h);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);
        g.setColor(0xffffff);
        g.fillArc(0, 0, w, h, 0, 360);
        Label label2 = new Label(maskImage);
        Object mask = maskImage.createMask();
        Image maskedImage = profilePic.applyMask(mask);
        profilePicButton = new Button(MyApplication.getConnectedUser().getUsername(),maskedImage);
        Container topBar = BorderLayout.west(profilePicButton);
        profilePicButton.addActionListener((evt) -> {
           MyApplication.setCurrentView(this.renderTerminalView(ProfileForm.class));
        });
        topBar.add(BorderLayout.EAST, Settings);
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);
        tb.addMaterialCommandToSideMenu("Ajouter Actualite", FontImage.MATERIAL_HOME, e -> {MyApplication.setCurrentView(this.renderTerminalView(AddActualiteForm.class));}); 
        tb.addMaterialCommandToSideMenu("Plan", FontImage.MATERIAL_HOME, e -> {MyApplication.setCurrentView(this.renderTerminalView(ListPlanView.class));}); 
        tb.addMaterialCommandToSideMenu("Evenemments", FontImage.MATERIAL_WEB, e -> {/*EventsLister c = new EventsLister(MyApplication.getTheme()); c.getListForm().show(); */});
        tb.addMaterialCommandToSideMenu("Relation", FontImage.MATERIAL_SETTINGS, e -> {/* Votre fonction ici */});
        tb.addMaterialCommandToSideMenu("Matching", FontImage.MATERIAL_INFO, e -> {MyApplication.setCurrentView(new VoirMatchingView(MyApplication.getTheme()));});  
        tb.addMaterialCommandToSideMenu("Horoscope", FontImage.MATERIAL_INFO, e -> {MyApplication.setCurrentView(this.renderTerminalView(HoroscopeForm.class));});  
        load_acts();   
    }
     private Form renderTerminalView(Class s ) //an instance of TerminalView 
     {
        MyApplication.enableTollBar(false);
        this.getToolbar().closeSideMenu();
        Object o=null;
        try {
            o = s.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println("Casting error check if your Class implements TerminalView");
        }
        TerminalView V;
        V=(TerminalView)o;
        Form f =(Form) V;
         return (Form)V ;
     }
     private void load_acts() {
        Resources res =MyApplication.getTheme();
        this.setLayout(BoxLayout.y());
        Toolbar tb = new Toolbar(true);
      
        ActualiteService controller = new ActualiteService();
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(Constants.GET_ACTUALITE);
        req.addResponseListener((NetworkEvent evt) -> {
            ArrayList<Actualite> actualites = controller.ParseActualite(new String(req.getResponseData()));
            for (int i = 0; i < actualites.size(); i++)  {
                addButton(
                        res,
                        actualites.get(i).getPhoto(),
                        actualites.get(i).getDateAdd(),
                        actualites.get(i).getUsername(),
                        actualites.get(i).getContenu(),
                        actualites.get(i)
                );
            }

        });

        NetworkManager.getInstance().addToQueue(req);
        refreshTheme();

     }
      private void addButton(Resources res, String img, String title, String email, String categorie, Actualite a) {
        //load image from url
        ImageViewer image = new ImageViewer();
        image.setImage(URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(150, 150, 0xffff0000), false), img,
                Constants.IMAGE_ACTUALITE_URL + img));

        Button button = new Button();
        button.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        cnt.setLeadComponent(button);
      
       

        
        Label ta = new Label(title, "Label");
        //set font motif to label
        FontImage.setMaterialIcon(ta, FontImage.MATERIAL_DATE_RANGE);
        
        Label category = new Label(categorie, "Label");
        FontImage.setMaterialIcon(category, FontImage.MATERIAL_CHAT);

        Label emails = new Label(email + "", "Label");
        FontImage.setMaterialIcon(emails, FontImage.MATERIAL_PERSON);

        cnt.add(BorderLayout.CENTER,
                BoxLayout.encloseY(
                        new Label(""),
                        new Label(""),
                        new Label(""),
                        new Label(""),
                        new Label(""),
                        new Label(""),
                        ta,
                        BoxLayout.encloseX(category),
                        BoxLayout.encloseX(emails)
                )
        );

        add(cnt);

        button.addActionListener((ActionListener) (ActionEvent e) -> {

          new DetailsActualiteForm(res,a).show();

        });
        this.animateLayout(0);
        refreshTheme();
    }
//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("MainFrameView");
        setName("MySoulMate");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}