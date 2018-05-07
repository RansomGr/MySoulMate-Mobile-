/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Events;

import Views.TerminalView;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import Views.Events.SmsApi;

/**
 * GUI builder created Form
 *
 * @author dellpro
 */
public class EvtAfficherView extends com.codename1.ui.Form implements TerminalView{

    public EvtAfficherView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_form();
    }
    
    public EvtAfficherView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_form();
    }
    @Override
    public void init_form()
    {
        TerminalView.super.init_form();
        //Smsapiii();
        
    }
    public void setContent(Container c)
    {
        this.add(c);
        
    }
    public void Smsapiii()
    {
        Container x = new Container(BoxLayout.x());
        Button smss = new Button("SMS");
        Container y = new Container(BoxLayout.y());
        y.addAll(smss);
        x.addAll(y);
        this.add(x);
        smss.addActionListener((evt) -> {
            String smssbody= "invite";
            //smssbody = "done";
            //smss.sendSms(smssbody);
        });
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("EvtAfficherView");
        setName("EvtAfficherView");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
