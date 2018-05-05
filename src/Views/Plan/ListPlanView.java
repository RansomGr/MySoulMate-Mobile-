/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Plan;

import Views.TerminalView;
import com.codename1.ui.Button;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;

/**
 * GUI builder created Form
 *
 * @author irou
 */
public class ListPlanView extends com.codename1.ui.Form implements TerminalView {
    
   
    public ListPlanView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        init_form();
       
    }
    
    public ListPlanView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        init_form();
       
    }
    @Override
    public void init_form()
    {
        TerminalView.super.init_form();
         this.setLayout(BoxLayout.y());
        this.addComponent(new PlanSingleComp());
       
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ListPlanView");
        setName("ListPlanView");
        addComponent(gui_Label);
        gui_Label.setText("Irou");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
