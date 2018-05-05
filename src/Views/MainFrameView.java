/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.User.UserAccountView;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
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
         Image  icon = MyApplication.getTheme().getImage("settings.png"); 
         icon=  icon.scaled(48, 48);
         Button b= new Button(icon);
         b.addActionListener((evt) -> {
          MyApplication.enableTollBar(false);
          MyApplication.setCurrentView(new UserAccountView(MyApplication.getTheme()));
         });
         Container topBar = BorderLayout.west(new Label("MySoulMate"));
         b.addActionListener((ActionEvent evt )-> {
           System.out.println("clicked");
        });
        topBar.add(BorderLayout.CENTER,b);
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

    tb.addMaterialCommandToSideMenu("Plan", FontImage.MATERIAL_HOME, e -> {/* Votre fonction ici */}); 
    tb.addMaterialCommandToSideMenu("Evenemments", FontImage.MATERIAL_WEB, e -> {/* Votre fonction ici */});
    tb.addMaterialCommandToSideMenu("Relation", FontImage.MATERIAL_SETTINGS, e -> {/* Votre fonction ici */});
    tb.addMaterialCommandToSideMenu("Matching", FontImage.MATERIAL_INFO, e -> {/* Votre fonction ici */});  
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
