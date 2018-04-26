/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;

/**
 *
 * @author Ransom
 */
public class MainFrameView extends AbstractView {
    private Toolbar tb;
    private Image icon;
    private Container topBar;
    public MainFrameView()
    {
        super();// call Super Class Constructor
        Toolbar.setGlobalToolbar(true);
        this.View=uib.createContainer(theme,"ui_MainFrame").getComponentForm();// Getting Instence of Form 
        init_MAinFrameView();
        this.View.setTitle("MySoulMate");// setting title on head of View
     
       
    }
    private void init_MAinFrameView()
    {
       this.View =uib.createContainer(theme,"ui_MainFrame").getComponentForm();
         tb=this.View.getToolbar();
           icon = theme.getImage("heart.png"); 
         icon=  icon.scaled(48, 48);
         Button b= new Button(icon);
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
}
