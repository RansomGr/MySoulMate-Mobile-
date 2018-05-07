/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Events;

import Entities.Events.Events;
import Service.Events.ServiceEvents;
import Views.TerminalView;
import com.codename1.components.SpanLabel;
import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;

/**
 * GUI builder created Form
 *
 * @author dellpro
 */
public class EventsListerView extends com.codename1.ui.Form implements TerminalView{

    ServiceEvents serviceevent = new ServiceEvents();
    ArrayList<Events> evts = new ArrayList<>();
    SpanLabel lb;
    public EventsListerView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_form();
    }
    
    public EventsListerView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_form();
    }
    @Override
    public void init_form()
    {
        TerminalView.super.init_form();
        this.setLayout(BoxLayout.y());
        fillinTheBlanks();
       /* gui_ButtonSms.addActionListener((evt) -> {
           // EventsLister evtlst = new EventsLister();
           //evtlst.addEvt(e, res);
            SmsApi smsa = new SmsApi();
           // smsa.sendSms(body);
            System.out.println("smssss");
                       
        });
        
         lb= new SpanLabel("");
            this.add(lb);
            serviceevent =new ServiceEvents();
            evts = serviceevent.getListEvt();
            if(evts!=null && evts.isEmpty())
            {
                for (Events evt : evts){
             System.out.println("hire2");
            addEvt(evt);
           
        }
                //initEvt();
            }
            */
    }
    private void fillinTheBlanks()
    {
        serviceevent =new ServiceEvents();
        evts = serviceevent.getListEvt();
        for(Events e:evts)
        {
            renderOneCell(e);
        }
    }
    private void renderOneCell(Events e)  
    {
        Container x = new Container(BoxLayout.x());
        Label descr = new Label("Description : "+e.getDescriptionEvt());
        Label type = new Label("Type : "+e.getTypeEvt());
        Label nom = new Label(e.getNomEvt());
        Label dureev = new Label("Durée : "+e.getDureeEvt());
        Button detail = new Button("Detail");
        Button smss = new Button("SMS");
        Container y = new Container(BoxLayout.y());
        y.addAll(dureev,type,descr,smss);
        x.addAll(detail,y);
        this.add(x);
        detail.addActionListener((evt) -> {
            detailbut(e);
        });
        smss.addActionListener((evt) -> {
           String bodyss= "invite";
            try {
                //smss.sendSms(bodyss);
                Display.getInstance().sendSMS("+21621821220", bodyss);//tSMS("+21621821220", "My SMS Message");
            } catch (IOException ex) {
                System.err.println("erreurrr");
            }
            Test mus = new Test();
            mus.show();
        });
                   
    }
    
    private void detailbut(Events e)
    {
        Container x1 = new Container(BoxLayout.x());
        Label descr = new Label("Description : "+e.getDescriptionEvt());
        Label type = new Label("Type : "+e.getTypeEvt());
        Label dureev = new Label("Durée : "+e.getDureeEvt());
        Label nom = new Label("paricipants : "+e.getNomEvt());
        Container y1 = new Container(BoxLayout.y());
        y1.addAll(type,nom,dureev,descr);
        x1.addAll(y1);
        //add(x1);
        EvtAfficherView evtaff = new EvtAfficherView();
        evtaff.setContent(x1);
        evtaff.show();
    }
    
public void addEvt(Events e ){
       
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
        
                new EvtAfficher( e).show();
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

           private void initEvt() {
        }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Ev\u00E9nements");
        setName("EventsListerView");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    
}
