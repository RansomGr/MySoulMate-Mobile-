/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Events;

import Entities.Events.Events;
import Service.Events.ServiceEvents;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.util.List;

/**
 *
 * @author dellpro
 */
public class EventsLister {
 private Form listForm;
   
    public EventsLister() {
    }

    public Form getListForm() {
        return listForm;
    }

    public void setListForm(Form listForm) {
        this.listForm = listForm;
    }
    
    
    private List<Events>listEvent;
    public EventsLister(Resources res) {
        
          listForm = new Form(BoxLayout.y());
          
             listEvent=new ServiceEvents().getListEvt();
     
             System.out.println("hire");
             System.out.println(listEvent);
             
        for (Events evt : listEvent){
             System.out.println("hire2");
            addEvt(evt,res);
           
        }
        
        // this.sideMenu(listForm, res);
    }
    
public void addEvt(Events e,Resources res ){
       
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      
//           ImageViewer imageEvt=new ImageViewer();
//           
//            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(listForm.getWidth(), 250), true);
//            imageEvt.setImage(URLImage.createToStorage(placeholder, "user_"+e.getPhoto(), "http://localhost:8181/espritentraideINTEG1/EspritEntreAideINTEG1/web/uploads/images/"+e.getPhoto()));
//      
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label nom =new Label("nom : "+e.getNomEvt());
        Label descript = new Label("email : "+e.getDescriptionEvt());
        Label dateevt = new Label("categorie(s) : "+e.getDateEvt());
        Label go = new Label("--->");
        Label go1 = new Label("*********************************************");
        Label description ;
          
        if(e.getDescriptionEvt().equals("")){
                 description = new Label("description : pas de description");
        }
        else{
                 description = new Label("description : "+e.getDescriptionEvt());
        }
         
        
        go.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
        
                new EvtAfficher(res, e).getListerForm().show();
            }
        });
        
              C2.add(nom.getText());
              C2.add(descript.getText());
              C2.add(dateevt.getText());
              C2.add(description.getText());
              C2.add(go);
              C2.add(go1);
       
        //C1.add(imageUser);
       // C1.add(C2);
        System.out.println("hire3");
        listForm.add(C2);
          
          
      }
    
}
