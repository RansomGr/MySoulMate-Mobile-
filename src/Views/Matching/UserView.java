/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Matching;

import com.mycompany.myapp.MyApplication;

/**
 * GUI builder created Form
 *
 * @author Nadia
 */
public class UserView extends com.codename1.ui.Form {

    public UserView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public UserView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_Inviter_btn.addActionListener((evt) -> {
           MyApplication.setCurrentView(this);
        });
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Nom_label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Compa_label = new com.codename1.ui.Label();
    private com.codename1.components.ImageViewer gui_Photo_img = new com.codename1.components.ImageViewer();
    private com.codename1.ui.Button gui_Inviter_btn = new com.codename1.ui.Button();
    private com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("UserView");
        setName("UserView");
        addComponent(gui_Nom_label);
        addComponent(gui_Compa_label);
        addComponent(gui_Photo_img);
        addComponent(gui_Inviter_btn);
        addComponent(gui_Container);
        gui_Nom_label.setPreferredSizeStr("13.607499mm inherit");
        gui_Nom_label.setText("Nom");
        gui_Nom_label.setUIID("Nom_label");
                gui_Nom_label.setInlineStylesTheme(resourceObjectInstance);
        gui_Nom_label.setName("Nom_label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Nom_label.getParent().getLayout()).setInsets(gui_Nom_label, "auto 1.2095554mm 1.5119443mm 2.2679176mm").setReferenceComponents(gui_Nom_label, "-1 1 3 1 ").setReferencePositions(gui_Nom_label, "0.0 0.0 1.0 0.0");
        gui_Compa_label.setPreferredSizeStr("17.084972mm inherit");
        gui_Compa_label.setText("Compa %");
        gui_Compa_label.setUIID("Compa_label");
                gui_Compa_label.setInlineStylesTheme(resourceObjectInstance);
        gui_Compa_label.setInlineAllStyles("fgColor:ff6072; bgImage:null;");
        gui_Compa_label.setName("Compa_label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Compa_label.getParent().getLayout()).setInsets(gui_Compa_label, "auto auto -1.5119444mm 0.0mm").setReferenceComponents(gui_Compa_label, "-1 3 3 3 ").setReferencePositions(gui_Compa_label, "0.0 0.0 1.0 0.0");
        gui_Photo_img.setPreferredSizeStr("13.4563055mm 11.490777mm");
        gui_Photo_img.setUIID("Photo_img");
                gui_Photo_img.setInlineStylesTheme(resourceObjectInstance);
        gui_Photo_img.setName("Photo_img");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Photo_img.getParent().getLayout()).setInsets(gui_Photo_img, "auto auto -0.90716666mm 0.60477775mm").setReferenceComponents(gui_Photo_img, "-1 0 0 1 ").setReferencePositions(gui_Photo_img, "0.0 0.0 1.0 0.0");
        gui_Inviter_btn.setPreferredSizeStr("inherit 6.0477777mm");
        gui_Inviter_btn.setUIID("Inviter_btn");
                gui_Inviter_btn.setInlineStylesTheme(resourceObjectInstance);
        gui_Inviter_btn.setName("Inviter_btn");
        gui_Inviter_btn.setIcon(resourceObjectInstance.getImage("inviter_btn.png"));
        ((com.codename1.ui.layouts.LayeredLayout)gui_Inviter_btn.getParent().getLayout()).setInsets(gui_Inviter_btn, "auto auto 2.2679167mm 22.277227%").setReferenceComponents(gui_Inviter_btn, "-1 -1 -1 -1").setReferencePositions(gui_Inviter_btn, "0.0 0.0 0.0 0.0");
        gui_Container.setPreferredSizeStr("27.063805mm 27.668583mm");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setInlineAllStyles("bgColor:ffb4de; transparency:35;");
        gui_Container.setName("Container");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)27.063805);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)27.668583);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "1.3607502mm 1.5119448mm 0.0mm 1.9655275mm").setReferenceComponents(gui_Container, "-1 -1 3 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
