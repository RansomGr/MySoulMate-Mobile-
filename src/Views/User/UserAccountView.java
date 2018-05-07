/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.User;

import Singletons.BackCommand;
import Views.TerminalView;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.events.FocusListener;
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.MyApplication;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;

/**
 * GUI builder created Form
 *
 * @author Ransom
 */
public class UserAccountView extends com.codename1.ui.Form implements TerminalView {
    private List<Component>guis;
    private int mode; // {0 : enable , 1 : revert, 2 : update }
    private int Gender;
    public UserAccountView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_form();
        init_actions();
    }
    public UserAccountView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);  
        init_form();
        init_actions();   
    }
    private void fire_btn(){
              switch (mode) {
                case 1:
                    for(Component t: guis){
                        t.setEnabled(false);
                    }      
                    if(Gender>0) {gui_man.setVisible(false);gui_woman.setVisible(true);} else {gui_man.setVisible(true);gui_woman.setVisible(false);}
                    update_button_state(0);
                    break;
                case 2: // updating the  user
                     if(Dialog.show("Mise A jour","Voulez vous vraiment mettre a jour vos données ?", "Oui","Non" ))
                     {
                         // update here
                     }
                     else
                     {
                     revert(); 
                     }
                    break;
                case 0:
                    for(Component t: guis){
                        t.setEnabled(true);
                    }   gui_woman.setVisible(true);
                    gui_man.setVisible(true);
                    update_button_state(1);
                    break;
            }
    }
    private void revert() {
        gui_nom.setText(MyApplication.getConnectedUser().getNom());
        gui_prenom.setText(MyApplication.getConnectedUser().getPrenom());
        gui_datenaissancee.setDate(MyApplication.getConnectedUser().getDatenaissance());
         for(Component t: guis){
            t.setEnabled(false);
            
        }
         update_button_state(0);
        if(MyApplication.getConnectedUser().getGender().equals("H"))
        {
            gui_man.setSelected(true);
             if(mode==2)
            {
            gui_woman.setVisible(true);
            gui_man.setVisible(true);  
            }
             else
             {
             gui_woman.setVisible(false);
             gui_man.setVisible(true);
             Gender=0;
             }
        }
        else
        {
            gui_woman.setSelected(true);
            if(mode==2)
            {
              gui_woman.setVisible(true);
              gui_man.setVisible(true);
                update_button_state(0);
            }else
            {
            gui_woman.setVisible(true);
            gui_man.setVisible(false);
            Gender=1;
            }
        }
  
    }
    private void update_button_state(int mode)  {
        this.mode=mode;
        switch(this.mode)
        {
            case 1 :
             gui_update.setText("Annuler");
             gui_update.setIcon(FontImage.createMaterial(FontImage.MATERIAL_CANCEL, gui_update.getUnselectedStyle()));
             break ;
             case 2:
             gui_update.setText("Enregister");
             gui_update.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SAVE, gui_update.getUnselectedStyle()));
             break ;
            case 0 :
             gui_update.setText("Mettre a Jour");
             gui_update.setIcon(FontImage.createMaterial(FontImage.MATERIAL_UPDATE, gui_update.getUnselectedStyle()));
             break;
        }
      
    }
    private void init_actions() {   
        gui_update.addActionListener((evt) -> {
            evt.consume();// somewhy thread is called twice when i don't consume !
             fire_btn();
        });
        
        for(Component t: guis){
            if(t instanceof TextField)((TextField)t).addDataChangeListener((int x, int y)->{
                update_button_state(2);
            });
            else if(t instanceof RadioButton)((RadioButton)t).addActionListener((evt) -> {
                if(((RadioButton)t).getButtonGroup().getSelectedIndex()!=Gender)
                    update_button_state(2);
            });
            else if(t instanceof Picker)((Picker)t).addActionListener((evt)->{
                if(!((Picker)t).getDate().equals(MyApplication.getConnectedUser().getDatenaissance()))
                    update_button_state(2);
            });
         }
         
        
    }
    @Override
    public void init_form(){
        TerminalView.super.init_form();
        mode=0;// form locked waiting to unlock on click
        guis= new ArrayList<>();
        guis.add(gui_nom);
        guis.add(gui_datenaissancee);
        guis.add(gui_man);
        guis.add(gui_prenom);
        guis.add(gui_woman);   
        gui_datenaissancee.setType(Display.PICKER_TYPE_DATE);
        revert();
        
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_nom = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_prenom = new com.codename1.ui.TextField();
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    private com.codename1.ui.spinner.Picker gui_datenaissancee = new com.codename1.ui.spinner.Picker();
    private com.codename1.components.SpanButton gui_update = new com.codename1.components.SpanButton();
    private com.codename1.ui.Container gui_Grid_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(1, 2));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.RadioButton gui_man = new com.codename1.ui.RadioButton();
    private com.codename1.ui.RadioButton gui_woman = new com.codename1.ui.RadioButton();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Info Utilisateur");
        setName("UserAccountView");
        addComponent(gui_Label);
        addComponent(gui_nom);
        addComponent(gui_prenom);
        addComponent(gui_Label_2);
        addComponent(gui_datenaissancee);
        addComponent(gui_update);
        addComponent(gui_Grid_Layout);
        gui_Grid_Layout.setPreferredSizeStr("74.07407mm 18.25397mm");
                gui_Grid_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout.setName("Grid_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Grid_Layout.getParent().getLayout()).setInsets(gui_Grid_Layout, "0.2645502mm 10.0% auto 10.0%").setReferenceComponents(gui_Grid_Layout, "2 -1 -1 -1").setReferencePositions(gui_Grid_Layout, "1.0 0.0 0.0 0.0");
        gui_Grid_Layout.addComponent(gui_Label_1);
        gui_Grid_Layout.addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_Y.setPreferredSizeStr("39.15344mm 19.57672mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        gui_Box_Layout_Y.addComponent(gui_man);
        gui_Box_Layout_Y.addComponent(gui_woman);
        gui_man.setPreferredSizeStr("26.190475mm inherit");
        gui_man.setSelected(false);
        gui_man.setText("Homme");
                gui_man.setInlineStylesTheme(resourceObjectInstance);
        gui_man.setGroup("gender");
        gui_man.setName("man");
        gui_woman.setPreferredSizeStr("27.513227mm inherit");
        gui_woman.setText("Femme");
                gui_woman.setInlineStylesTheme(resourceObjectInstance);
        gui_woman.setGroup("gender");
        gui_woman.setName("woman");
        gui_Label_1.setText("Gender");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Box_Layout_Y.setPreferredSizeStr("39.15344mm 19.57672mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        gui_Label.setPreferredSizeStr("73.280426mm 1.3227513mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "4.2328043mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        gui_nom.setPreferredSizeStr("inherit 6.878306865692139mm");
        gui_nom.setHint("Nom");
                gui_nom.setInlineStylesTheme(resourceObjectInstance);
        gui_nom.setInlineAllStyles("border:1.0mm underline eb5966;");
        gui_nom.setInlineDisabledStyles("opacity:50;");
        gui_nom.setName("nom");
        ((com.codename1.ui.layouts.LayeredLayout)gui_nom.getParent().getLayout()).setInsets(gui_nom, "-2.1164021mm 10.0% auto 10.0%").setReferenceComponents(gui_nom, "0 -1 -1 -1").setReferencePositions(gui_nom, "0.0 0.0 0.0 0.0");
        gui_prenom.setPreferredSizeStr("inherit 6.878306865692139mm");
        gui_prenom.setHint("Prenom");
                gui_prenom.setInlineStylesTheme(resourceObjectInstance);
        gui_prenom.setInlineAllStyles("border:1.0mm underline eb5966;");
        gui_prenom.setInlineDisabledStyles("opacity:50;");
        gui_prenom.setName("prenom");
        ((com.codename1.ui.layouts.LayeredLayout)gui_prenom.getParent().getLayout()).setInsets(gui_prenom, "-1.3227513mm 10.0% auto 10.0%").setReferenceComponents(gui_prenom, "1 -1 -1 -1").setReferencePositions(gui_prenom, "1.0 0.0 0.0 0.0");
        gui_Label_2.setPreferredSizeStr("74.07407mm inherit");
        gui_Label_2.setText("Date Naissance");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.26455027mm 10.0% auto 10.0%").setReferenceComponents(gui_Label_2, "6 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        gui_datenaissancee.setPreferredSizeStr("inherit 7.0mm");
        gui_datenaissancee.setText("...");
                gui_datenaissancee.setInlineStylesTheme(resourceObjectInstance);
        gui_datenaissancee.setInlineAllStyles("border:1.0mm underline eb5966;");
        gui_datenaissancee.setInlineDisabledStyles("fgColor:0; opacity:50;");
        gui_datenaissancee.setName("datenaissancee");
        ((com.codename1.ui.layouts.LayeredLayout)gui_datenaissancee.getParent().getLayout()).setInsets(gui_datenaissancee, "-2.1164021mm 10.0% auto 10.0%").setReferenceComponents(gui_datenaissancee, "3 -1 -1 -1").setReferencePositions(gui_datenaissancee, "1.0 0.0 0.0 0.0");
        gui_datenaissancee.setType(4);
        gui_update.setPreferredSizeStr("32.80423355102539mm inherit");
        gui_update.setText("Mettre A jour");
                gui_update.setInlineStylesTheme(resourceObjectInstance);
        gui_update.setInlineAllStyles("alignment:left;");
        gui_update.setName("update");
        com.codename1.ui.FontImage.setMaterialIcon(gui_update,"\ue923".charAt(0));
        ((com.codename1.ui.layouts.LayeredLayout)gui_update.getParent().getLayout()).setInsets(gui_update, "auto 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_update, "-1 -1 -1 -1").setReferencePositions(gui_update, "0.0 0.0 0.0 0.0");
        gui_Grid_Layout.setPreferredSizeStr("74.07407mm 18.25397mm");
                gui_Grid_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout.setName("Grid_Layout");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Grid_Layout.getParent().getLayout()).setInsets(gui_Grid_Layout, "0.2645502mm 10.0% auto 10.0%").setReferenceComponents(gui_Grid_Layout, "2 -1 -1 -1").setReferencePositions(gui_Grid_Layout, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!


}
