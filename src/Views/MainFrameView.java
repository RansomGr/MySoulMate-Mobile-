/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Utils.Constants;
import Views.Matching.VoirMatchingView;
import Views.Events.EventsLister;
import Views.Events.EvtAfficher;
import Views.Events.Test;
import Views.Plan.ListPlanView;
import Views.User.UserAccountView;
import com.codename1.components.ImageViewer;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.mycompany.myapp.MyApplication;

/**
 * GUI builder created Form
 *
 * @author Ransom
 */
public class MainFrameView extends com.codename1.ui.Form {

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
        Toolbar tb=this.getToolbar();    
     /*   Image  icon = MyApplication.getTheme().getImage("settings.png"); 
        icon=  icon.scaled(48, 48);
        Button b= new Button(icon);
        b.addActionListener((evt) -> {  
        MyApplication.enableTollBar(false);
        MyApplication.setCurrentView(this.renderTerminalView(UserAccountView.class));
        });*/
        Container topBar = BorderLayout.west(new Label("MySoulMate"));
    /*    b.addActionListener((ActionEvent evt )-> {
        System.out.println("clicked");
        });*/
        //topBar.add(BorderLayout.CENTER,b);
 
      
        Image profilePic =  URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(150, 150, 0xffff0000), false),MyApplication.getConnectedUser().getProfil().getPhoto(),
                            Constants.IMAGE_PROFILE_URL+MyApplication.getConnectedUser().getProfil().getPhoto());
        Image mask = MyApplication.getTheme().getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label("  Jennifer Wilson", profilePic, "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());
        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);
        tb.addMaterialCommandToSideMenu("Plan", FontImage.MATERIAL_HOME, e -> {MyApplication.setCurrentView(this.renderTerminalView(ListPlanView.class));}); 
        tb.addMaterialCommandToSideMenu("Evenemments", FontImage.MATERIAL_WEB, e -> {/*EventsLister c = new EventsLister(MyApplication.getTheme()); c.getListForm().show(); */});
        tb.addMaterialCommandToSideMenu("Relation", FontImage.MATERIAL_SETTINGS, e -> {/* Votre fonction ici */});
        tb.addMaterialCommandToSideMenu("Matching", FontImage.MATERIAL_INFO, e -> {MyApplication.setCurrentView(new VoirMatchingView(MyApplication.getTheme()));});  
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
         return (Form)V ;
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
