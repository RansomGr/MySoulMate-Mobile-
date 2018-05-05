/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Events;

import Views.TerminalView;

/**
 * GUI builder created Form
 *
 * @author dellpro
 */
public class EventsAjouterGui extends com.codename1.ui.Form implements TerminalView{

    public EventsAjouterGui() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    @Override
    public void init_form()
    {
        TerminalView.super.init_form();
    }
    
    public EventsAjouterGui(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_form();
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("EventsAjouterGui");
        setName("EventsAjouterGui");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
