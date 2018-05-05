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
public class EventsListerGui extends com.codename1.ui.Form implements TerminalView{

    public EventsListerGui() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_form();
    }
    @Override
    public void init_form()
    {
        TerminalView.super.init_form();
    }
    
    public EventsListerGui(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_form();
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
    }
//-- DON'T EDIT ABOVE THIS LINE!!!
}
