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
public class EvtAfficherGui extends com.codename1.ui.Form implements TerminalView{

    public EvtAfficherGui() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    @Override
    public void init_form()
    {
        TerminalView.super.init_form();
    }
    
    public EvtAfficherGui(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_form();
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
    }
//-- DON'T EDIT ABOVE THIS LINE!!!
}
