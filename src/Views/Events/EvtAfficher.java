/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Events;

import Entities.Events.Events;
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
public class EvtAfficher extends com.codename1.ui.Form{
     private Form listForm;
    private List<Events>listEvt;
    public EvtAfficher(Resources res,Events evt1) {
        
          listForm = new Form(BoxLayout.y());
          addEvt(evt1);
        // this.sideMenu(listForm, res);
  }

      public void addEvt(Events e ){
       
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      
//           ImageViewer imageUser=new ImageViewer();
//           
//            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(listForm.getWidth(), 250), true);
//            imageUser.setImage(URLImage.createToStorage(placeholder, "user_"+e.getPhoto(), "http://localhost:8181/espritentraideINTEG1/EspritEntreAideINTEG1/web/uploads/images/"+e.getPhoto()));
//      
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label nom =new Label("nom : "+e.getNomEvt());
        Label descript = new Label("email : "+e.getDescriptionEvt());
        Label dateevt = new Label("categorie(s) : "+e.getDateEvt());
        Label description ;
          
        if(e.getDescriptionEvt().equals("")){
                 description = new Label("description : pas de description");
        }
        else{
                 description = new Label("description : "+e.getDescriptionEvt());
        }
         
        
//        imageUser.addPointerPressedListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//           
//         /*        
//            Form f2 = new Form(BoxLayout.y());
//            f2.setTitle(e.getNom());
//            ImageViewer imgDrp = new ImageViewer(theme.getImage(e.getImg()));
//            Container c = new Container(BoxLayout.x());
//            for(int i=0 ; i<e.getNbTitre(); i++){
//                c.add(new ImageViewer(theme.getImage("cup.png")));
//                }
//            
//            f2.add(imgDrp);
//            f2.add(c);
//            
//            f2.show();
//         */
//            }
//        });
//        
              C2.add(nom.getText());
              C2.add(descript.getText());
              C2.add(dateevt.getText());;
              C2.add(description.getText());
       
       
        //C1.add(imageUser);
       C1.add(C2);
//        C1.setLeadComponent(imageUser);
        
        listForm.add(C1);
          
          
      }
    
    public Form getListerForm() {
        return listForm;
    }

    public void setListerForm(Form listForm) {
        this.listForm = listForm;
    }
    
}
