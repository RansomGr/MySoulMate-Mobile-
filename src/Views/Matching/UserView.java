/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Matching;

import Entities.User.User;
import Service.Matching.ServiceMatching;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;

/**
 * GUI builder created Container
 *
 * @author Nadia
 */
public class UserView extends com.codename1.ui.Container {

    public UserView(User a) {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        gui_nom_label.setText("7abcha9leu");
        gui_compa_label.setText("descripetion test");
        gui_Button.addActionListener((evt) -> {
        ServiceMatching service = new ServiceMatching();
        //service.Inviter( a.getNom() );
        });
                
        
        
        ServiceMatching controller = new ServiceMatching();
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl("http://localhost/MySoulMate-Symphony/web/app_dev.php/ ");
        req.addResponseListener((NetworkEvent evt) -> {
            
            ArrayList<User> matchings = controller.getList2();
            for (int i = 0; i < matchings.size(); i++) {
                      
                        matchings.get(i).getProfil().getPhoto() ;
                        matchings.get(i).getUsername();
                        matchings.get(i).getAdresse().getVille()  ;
                        matchings.get(i).getMatchtot();
                        
               
            }

        });

        NetworkManager.getInstance().addToQueue(req);
        refreshTheme();

    }
    
    
    public UserView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Grid_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(4, 1));
    private com.codename1.components.ImageViewer gui_Image_Viewer = new com.codename1.components.ImageViewer();
    private com.codename1.ui.Label gui_nom_label = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_compa_label = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("UserView");
        addComponent(gui_Grid_Layout);
        gui_Grid_Layout.setPreferredSizeStr("29.63411mm 30.843666mm");
                gui_Grid_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout.setName("Grid_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Grid_Layout.getParent().getLayout()).setInsets(gui_Grid_Layout, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Grid_Layout, "-1 -1 -1 -1").setReferencePositions(gui_Grid_Layout, "0.0 0.0 0.0 0.0");
        gui_Grid_Layout.addComponent(gui_Image_Viewer);
        gui_Grid_Layout.addComponent(gui_nom_label);
        gui_Grid_Layout.addComponent(gui_compa_label);
        gui_Grid_Layout.addComponent(gui_Button);
                gui_Image_Viewer.setInlineStylesTheme(resourceObjectInstance);
        gui_Image_Viewer.setInlineAllStyles("alignment:center;");
        gui_Image_Viewer.setName("Image_Viewer");
        gui_nom_label.setText("username");
                gui_nom_label.setInlineStylesTheme(resourceObjectInstance);
        gui_nom_label.setInlineAllStyles("alignment:center;");
        gui_nom_label.setName("nom_label");
        gui_compa_label.setText("   %");
                gui_compa_label.setInlineStylesTheme(resourceObjectInstance);
        gui_compa_label.setInlineAllStyles("fgColor:ff6072; alignment:center;");
        gui_compa_label.setName("compa_label");
        gui_Button.setText("Inviter");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setInlineAllStyles("alignment:center;");
        gui_Button.setName("Button");
        gui_Grid_Layout.setPreferredSizeStr("29.63411mm 30.843666mm");
                gui_Grid_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout.setName("Grid_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Grid_Layout.getParent().getLayout()).setInsets(gui_Grid_Layout, "0.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Grid_Layout, "-1 -1 -1 -1").setReferencePositions(gui_Grid_Layout, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
