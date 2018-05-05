/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Plan;

/**
 * GUI builder created Container
 *
 * @author irou
 */
public class PlanSingleComp extends com.codename1.ui.Container {

   //private Plan p;
    public PlanSingleComp() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        gui_nom.setText("7abcha9leu");
        gui_descr.setText("descripetion test");
    }
    
    public PlanSingleComp(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        gui_nom.setText("7abcha9leu");
        gui_descr.setText("descripetion test");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.components.ImageViewer gui_Image_Viewer = new com.codename1.components.ImageViewer();
    private com.codename1.ui.Label gui_nom = new com.codename1.ui.Label();
    private com.codename1.components.SpanLabel gui_descr = new com.codename1.components.SpanLabel();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setName("PlanSingleComp");
        addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_Y.setPreferredSizeStr("89.94709mm 44.708996mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_Y.addComponent(gui_Image_Viewer);
        gui_Box_Layout_Y.addComponent(gui_nom);
        gui_Box_Layout_Y.addComponent(gui_descr);
                gui_Image_Viewer.setInlineStylesTheme(resourceObjectInstance);
        gui_Image_Viewer.setName("Image_Viewer");
        gui_nom.setText("Nom");
                gui_nom.setInlineStylesTheme(resourceObjectInstance);
        gui_nom.setName("nom");
        gui_descr.setText("Description");
                gui_descr.setInlineStylesTheme(resourceObjectInstance);
        gui_descr.setName("descr");
        gui_Box_Layout_Y.setPreferredSizeStr("89.94709mm 44.708996mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
