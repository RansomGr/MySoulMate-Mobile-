/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Events;

import Entities.Events.Events;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author dellpro
 */
public class EventsAjouter extends com.codename1.ui.Form{
    Form AjouterForm;
    Container AjouterContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    TextField description;
    TextField titre;
    Button AjouterBtn;
    Events evt ;

    public Form getAjouterForm() {
        return AjouterForm;
    }

    public void setAjouterForm(Form AjouterForm) {
        this.AjouterForm = AjouterForm;
    }

    public EventsAjouter(Resources res) {
      evt = new Events();
        AjouterForm = new Form(new FlowLayout(Component.CENTER));

        titre = new TextField("", "titre");
        description = new TextField("", "description");

        AjouterBtn = new Button("ajouter");
        
        AjouterBtn.addActionListener(e->{
            /* 
            if(titre.getText().isEmpty()||description.getText().isEmpty()){
                 Dialog.show("remplissez tous les champs","ajout","ok",null);
                 return;
            }

            */
      
            evt.setHeure(titre.getText());
            evt.setDescriptionEvt(description.getText());
            //evt.setOrganisateurEvt(userSession);
           // new Service.Events.ServiceEvents().ajoutEvent(evt);
            Dialog.show("success","ajout","ok",null);
        });
        
        AjouterContainer.add(titre);
        AjouterContainer.add(description);
        AjouterContainer.add(AjouterBtn);
        
        AjouterForm.add(AjouterContainer);
        
        //sideMenu(AjouterForm, res);
      }
    
//      private void showToast(String text) {
//        Image errorImage = FontImage.createMaterial(FontImage.MATERIAL_ERROR, UIManager.getInstance().getComponentStyle("Title"), 4);
//        ToastBar.Status status = ToastBar.getInstance().createStatus();
//        status.setMessage(text);
//        status.setIcon(errorImage);
//        status.setExpires(2000);
//        status.show();
//    }
}
