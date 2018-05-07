/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Matching;

import Entities.Matching.Packaging;
import Entities.User.User;
import Service.Matching.ServicePackaging;
import Views.TerminalView;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GUI builder created Form
 *
 * @author Nadia
 */
public class PackView extends com.codename1.ui.Form implements TerminalView {
    
    ServicePackaging servicep = new ServicePackaging();
    List<Packaging> packagings = new ArrayList<>();
    SpanLabel lb;
    
    public PackView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_form();
    }
    
    public PackView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_form();
    }
    
    @Override
    public void init_form() {
        TerminalView.super.init_form();
        this.setLayout(BoxLayout.y());
        TextModeLayout tm = new TextModeLayout(4, 2);

        SpanLabel lb = new SpanLabel("");
        this.add(lb);
        ServicePackaging servicep = new ServicePackaging();
        packagings = servicep.getList2();
        if (packagings != null && !packagings.isEmpty()) {
            initi();
        }

    }

    private void initi() {
        int mm = Display.getInstance().convertToPixels(3);
       
        this.setLayout(BoxLayout.y());
        
        ArrayList<Map<String, Object>> data = new ArrayList<>();

        for (int i= 0; i < packagings.size(); i++) {
            
         

           
                try {

                    this.add(new Label(packagings.get(i).getNom()));
                    this.add(new Label( "profitez de"+packagings.get(i).getContenu()+ "%"));
                    this.add(new Label( " pendant "+packagings.get(i).getDuree()+" jours"));                   
                    this.add(new Label("à"+ packagings.get(i).getPrix()+" Dt"));
               

                } catch (Exception e) {
                    e.printStackTrace();
                }
            

         
            DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
            MultiList ml = new MultiList(model);
////////////////////////////////////////////////////////////////
            
            this.add(BoxLayout.y(),ml);
            ml.addActionListener((ActionListener) (ActionEvent evt) -> {

                servicep.Acheter(packagings.get(ml.getSelectedIndex()));

                Button showNotification = new Button("Notification");
                showNotification.addActionListener(e -> ToastBar.showMessage("Invitation envoyée!", FontImage.MATERIAL_INFO));
                this.add(showNotification);

            });

        }
   
        
        DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
    }
   


//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("PackView");
        setName("PackView");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
