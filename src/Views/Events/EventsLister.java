/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Events;

import Entities.Events.Events;
import Service.Events.ServiceEvents;
import Views.TerminalView;
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
import com.mycompany.myapp.MyApplication;
import java.util.List;

/**
 *
 * @author dellpro
 */
public class EventsLister extends com.codename1.ui.Form implements TerminalView {
    public EventsLister() {
        
        init_form();       
          this.setLayout(BoxLayout.y());          
             listEvent=new ServiceEvents().getListEvt();     
             System.out.println("hire");
             System.out.println(listEvent);             
        for (Events evt : listEvent){
             System.out.println("hire2");
            addEvt(evt,MyApplication.getTheme());
    }
    }
    @Override
    public void init_form()
    {
        TerminalView.super.init_form();
    }
    private List<Events>listEvent;
    public EventsLister(Resources res) {
        init_form();
        this.setLayout(BoxLayout.y());
             listEvent=new ServiceEvents().getListEvt();
             System.out.println("hire");
             System.out.println(listEvent);             
        for (Events evt : listEvent){
             System.out.println("hire2");
            addEvt(evt,res);
           
        }
    }
    
public void addEvt(Events e,Resources res ){
       
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label nom =new Label("Type: "+e.getTypeEvt());
        Label descript = new Label("description: "+e.getDescriptionEvt());
        Label dateevt = new Label("date: "+e.getDateEvt());
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
        
                new EvtAfficher(res, e).show();
            }
        });
        
              C2.add(nom.getText());
              C2.add(descript.getText());
              C2.add(dateevt.getText());
              C2.add(description.getText());
              C2.add(go);
              C2.add(go1);
        System.out.println("hire3");
        this.add(C2);      
      }
    
}
